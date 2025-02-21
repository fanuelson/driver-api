package com.lab.driverapi.gateways.outputs.http.impl;

import com.lab.driverapi.domain.delayapi.DelayApiDelay;
import com.lab.driverapi.gateways.outputs.http.DelayApiGateway;
import com.lab.driverapi.gateways.outputs.http.clients.delayApi.DelayApiClient;
import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.DelayApiDelayResponse;
import com.lab.driverapi.gateways.outputs.http.mappers.DelayApiOutputMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DelayApiGatewayImpl implements DelayApiGateway {

  private final DelayApiClient delayApiClient;

  private final DelayApiOutputMapper delayApiOutputMapper;

  @Override
  public DelayApiDelay delay(final Long delay) {
    val delayApiResponse = delayApiClient.delay(delay);
    return delayApiOutputMapper.toDomain(delayApiResponse);
  }

  DelayApiDelay delayFallback(Throwable throwable) {
    log.warn(
        "Retry ClientFallback no método delay, delay: {}, exception: {} ",
        0,
        throwable.getMessage());
    return delayApiOutputMapper.toDomain(
        new DelayApiDelayResponse("ClientFallback RETRY response for delayApi"));
  }
}
