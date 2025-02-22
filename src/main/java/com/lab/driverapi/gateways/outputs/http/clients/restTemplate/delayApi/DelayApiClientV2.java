package com.lab.driverapi.gateways.outputs.http.clients.restTemplate.delayApi;

import com.lab.driverapi.configuration.clients.ClientsProps;
import com.lab.driverapi.gateways.outputs.http.clients.helper.RestTemplateHelper;
import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.DelayApiDelayResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DelayApiClientV2 {

  static final String CLIENT_NAME = "DelayApiClient";
  private final RestTemplateHelper restTemplateHelper;
  private final ClientsProps clientsProps;

  @CircuitBreaker(name = CLIENT_NAME, fallbackMethod = "delayFallback")
  @RateLimiter(name = CLIENT_NAME, fallbackMethod = "delayFallback")
  public DelayApiDelayResponse delay(final Long delay) {
    val uri = getUrl("/delay/%s".formatted(delay));
    return restTemplateHelper.getForEntity(DelayApiDelayResponse.class, uri);
  }

  public DelayApiDelayResponse delayFallback(final Long delay, final Throwable throwable) {
    log.warn(
        "Executing fallback for DELAY_API client, delay: {}, exception: {}",
        delay,
        throwable.getMessage());

    return new DelayApiDelayResponse("Hello world fallback response");
  }

  private String getUrl() {
    return clientsProps.getDelayApiClient().getUrl();
  }

  private String getUrl(String resource) {
    return "%s/%s".formatted(getUrl(), resource);
  }
}
