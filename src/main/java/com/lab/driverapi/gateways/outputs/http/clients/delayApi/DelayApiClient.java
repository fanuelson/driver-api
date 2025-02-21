package com.lab.driverapi.gateways.outputs.http.clients.delayApi;

import static com.lab.driverapi.gateways.outputs.http.clients.delayApi.DelayApiClient.CLIENT_NAME;

import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.DelayApiDelayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = CLIENT_NAME, fallbackFactory = DelayApiClientFallback.class)
public interface DelayApiClient {

  String CLIENT_NAME = "DelayApiFeignClient";

  @GetMapping("/delay/{delay}")
  DelayApiDelayResponse delay(@PathVariable("delay") final Long delay);

}
