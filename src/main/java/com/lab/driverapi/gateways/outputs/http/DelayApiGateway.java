package com.lab.driverapi.gateways.outputs.http;

import com.lab.driverapi.domain.delayapi.DelayApiDelay;

public interface DelayApiGateway {

  DelayApiDelay delay(Long delay);
}
