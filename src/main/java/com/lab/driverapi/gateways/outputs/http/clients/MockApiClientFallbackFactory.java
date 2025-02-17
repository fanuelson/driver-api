package com.lab.driverapi.gateways.outputs.http.clients;

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
        log.warn("Executando fallback para Feign Client, exception: {}", throwable.getMessage());
        return new MockApiResponse("Hello Feign fallback");
      }
    };
  }
}
