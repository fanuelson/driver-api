package com.lab.driverapi.gateways.outputs.http.clients;

import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.MockApiResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "MockApiFeignClient",
    url = "http://localhost:4010",
    fallbackFactory = MockApiClientFallbackFactory.class)
public interface MockApiClient {

  @GetMapping("/hello")
  MockApiResponse getHello();
}
