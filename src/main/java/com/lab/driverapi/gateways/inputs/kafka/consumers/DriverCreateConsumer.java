package com.lab.driverapi.gateways.inputs.kafka.consumers;

import com.lab.driverapi.gateways.inputs.kafka.mappers.DriverResourceKafkaConsumerMapper;
import com.lab.driverapi.gateways.inputs.kafka.resources.DriverResource;
import com.lab.driverapi.usecases.CreateDriverUseCase;
import com.lab.driverapi.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DriverCreateConsumer {
  private final CreateDriverUseCase createDriverUseCase;
  private final DriverResourceKafkaConsumerMapper driverResourceKafkaConsumerMapper;
  private final JsonUtils jsonUtils;

  @KafkaListener(
      topics = {"${spring.kafka.topics.driverCreate}"},
      containerFactory = "kafkaListenerContainerFactory")
  public void consume(
      @Payload final String message,
      @Header(KafkaHeaders.RECEIVED_KEY) final String key,
      @Header(KafkaHeaders.RECEIVED_PARTITION) final String partitionId,
      @Header(KafkaHeaders.OFFSET) final String offset,
      @Header(KafkaHeaders.RECEIVED_TOPIC) final String topic) {
    log.info(
        "Message received from topic {} partitionId {} offset {} key {} message {}",
        topic,
        partitionId,
        offset,
        key,
        message);

    try {
      val driverResource = jsonUtils.toObject(message, DriverResource.class);
      val driver = driverResourceKafkaConsumerMapper.toDomain(driverResource);
      val driverSaved = createDriverUseCase.execute(driver);
      // TODO Implementar o send para o topic driverCreatedBroadcast
      log.info(
          "Enviar driver saved {} para o driverCreatedBroadcast", jsonUtils.toJson(driverSaved));
    } catch (final Exception exception) {
      log.error(
          "Kafka Consumer {}, Topic {} has failed for message {}.",
          getClass().getName(),
          topic,
          message,
          exception);
    }
  }
}
