package com.lab.driverapi.gateways.outputs;

import com.lab.driverapi.domain.Driver;

public interface SendDriverCreateGateway {

  void send(final Driver driver);
}
