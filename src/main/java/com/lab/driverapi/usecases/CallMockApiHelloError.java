package com.lab.driverapi.usecases;

import com.lab.driverapi.domain.mockapi.MockApiHello;
import com.lab.driverapi.gateways.outputs.http.MockApiGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CallMockApiHelloError {

  private final MockApiGateway mockApiGateway;

  public MockApiHello execute() {
    return mockApiGateway.getHelloError();
  }
}
