package com.lab.driverapi.gateways.outputs.http.clients.delayApi;

import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.DelayApiDelayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DelayApiClientFallback implements FallbackFactory<DelayApiClient> {

  @Override
  public DelayApiClient create(final Throwable throwable) {
    return (delay) -> {
      log.warn(
          "Executing fallback for DELAY_API client, delay: {}, exception: {}",
          delay,
          throwable.getMessage());
      return new DelayApiDelayResponse("Hello world fallback response, delay: " + delay);
    };
  }
}
