package com.lab.driverapi.gateways.outputs.http.clients;

import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.DelayApiDelayResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DelayApiClientFallbackFactory implements FallbackFactory<DelayApiClient> {

  @Override
  public DelayApiClient create(Throwable throwable) {
    return new DelayApiClient() {
      @Override
      public DelayApiDelayResponse delay(final Long delay) {
        log.warn(
            "Executando fallback para Client DELAY-API, param: {},  exception: {}",
            delay,
            throwable.getMessage());
        return new DelayApiDelayResponse(
            "Hello DELAY-API client fallback with delay: %s".formatted(delay.toString()));
      }
    };
  }
}
