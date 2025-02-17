package com.lab.driverapi.gateways.outputs.kafka.producers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BaseDriverApiProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String topic, String key, String message) {
    kafkaTemplate
        .send(topic, key, message)
        .thenAccept(
            result ->
                log.info(
                    "Message [{}] sent to topic: {}, key {}, partition: {}",
                    message,
                    result.getRecordMetadata().topic(),
                    result.getProducerRecord().key(),
                    result.getRecordMetadata().partition()))
        .exceptionally(
            ex -> {
              log.error(
                  "Failed to send message [{}] to topic: {} and key {}", message, key, topic, ex);
              return null;
            });
  }
}
