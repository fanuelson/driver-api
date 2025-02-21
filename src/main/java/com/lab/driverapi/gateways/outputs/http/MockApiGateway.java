package com.lab.driverapi.gateways.outputs.http;

import com.lab.driverapi.domain.mockapi.MockApiHello;

public interface MockApiGateway {

  MockApiHello getHello();

  MockApiHello getHelloError();
}
