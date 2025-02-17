package com.lab.driverapi.gateways.outputs.http.impl;

import com.lab.driverapi.domain.delayapi.DelayApiDelay;
import com.lab.driverapi.gateways.outputs.http.DelayApiGateway;
import com.lab.driverapi.gateways.outputs.http.clients.DelayApiClient;
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
}
