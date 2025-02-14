package com.lab.driverapi.gateways.outputs.kafka.producers;

import com.lab.driverapi.configuration.kafka.TopicProperties;
import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.outputs.SendDriverCreateGateway;
import com.lab.driverapi.gateways.outputs.kafka.mappers.DriverResourceKafkaMapper;
import com.lab.driverapi.utils.JsonUtils;
import com.lab.driverapi.utils.KafkaKeyGeneratorUtils;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendDriverCreateGatewayKafkaImpl implements SendDriverCreateGateway {
  private final DriverApiKafkaProducer driverApiKafkaProducer;
  private final TopicProperties topicProperties;
  private final DriverResourceKafkaMapper driverResourceKafkaMapper;
  private final JsonUtils jsonUtils;

  public void send(final Driver driver) {
    val topic = topicProperties.getDriverCreate();
    val key = KafkaKeyGeneratorUtils.generateKey(jsonUtils.toJson(driver));
    val driverResource = driverResourceKafkaMapper.toResource(driver);
    val driverResourceJson = jsonUtils.toJson(driverResource);
    driverApiKafkaProducer.sendMessage(topic, key, driverResourceJson);
  }
}
