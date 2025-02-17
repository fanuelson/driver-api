package com.lab.driverapi.gateways.outputs.http.impl;

import com.lab.driverapi.domain.mockapi.MockApiHello;
import com.lab.driverapi.gateways.outputs.http.MockApiGateway;
import com.lab.driverapi.gateways.outputs.http.clients.MockApiClient;
import com.lab.driverapi.gateways.outputs.http.mappers.MockApiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MockApiGatewayImpl implements MockApiGateway {

  private final MockApiClient mockApiClient;

  private final MockApiMapper mockApiMapper;

  @Override
  public MockApiHello getHello() {
    val mockApiResponse = mockApiClient.getHello();
    return mockApiMapper.toDomain(mockApiResponse);
  }

}
