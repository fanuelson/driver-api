package com.lab.driverapi.usecases;

import com.lab.driverapi.domain.delayapi.DelayApiDelay;
import com.lab.driverapi.gateways.outputs.http.DelayApiGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CallDelayApiDelay {

  private final DelayApiGateway delayApiGateway;

  public DelayApiDelay execute(final Long delay) {
    return delayApiGateway.delay(delay);
  }
}
