package com.lab.driverapi.gateways.outputs.http.clients.mockApi;

import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.MockApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MockApiClientFallbackFactory implements FallbackFactory<MockApiClient> {

  @Override
  public MockApiClient create(Throwable throwable) {
    return new MockApiClient() {
      @Override
      public MockApiResponse getHello() {
        log.warn("Executando fallback para Client MOCK-API -> hello(), exception: {}", throwable.getMessage());
        return new MockApiResponse("Hello MOCK-API client fallback");
      }

      @Override
      public MockApiResponse getHelloError() {
        log.warn("Executando fallback para Client MOCK-API -> helloError(), exception: {}", throwable.getMessage());
        return new MockApiResponse("Hello Error MOCK-API client fallback");
      }
    };
  }
}
