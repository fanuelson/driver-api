package com.lab.driverapi.gateways.outputs.http.clients.mockApi;

import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.MockApiResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import static com.lab.driverapi.gateways.outputs.http.clients.mockApi.MockApiClient.CLIENT_NAME;

@FeignClient(name = CLIENT_NAME, fallbackFactory = MockApiClientFallbackFactory.class)
public interface MockApiClient {

  String CLIENT_NAME = "MockApiFeignClient";

  @GetMapping("/hello")
  MockApiResponse getHello();

  @GetMapping("/hello-error")
  MockApiResponse getHelloError();
}
