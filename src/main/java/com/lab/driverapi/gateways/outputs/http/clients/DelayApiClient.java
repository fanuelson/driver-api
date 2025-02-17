package com.lab.driverapi.gateways.outputs.http.clients;

import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.DelayApiDelayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "DelayApiFeignClient",
    url = "http://localhost:4020",
    fallbackFactory = DelayApiClientFallbackFactory.class)
public interface DelayApiClient {

  @GetMapping("/delay/{delay}")
  DelayApiDelayResponse delay(@PathVariable("delay") final Long delay);
}
