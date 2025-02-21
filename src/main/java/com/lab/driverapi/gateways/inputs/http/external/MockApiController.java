package com.lab.driverapi.gateways.inputs.http.external;

import com.lab.driverapi.gateways.inputs.http.mappers.MockApiInputMapper;
import com.lab.driverapi.gateways.inputs.http.resources.responses.MockApiResponse;
import com.lab.driverapi.usecases.CallMockApiHello;
import com.lab.driverapi.usecases.CallMockApiHelloError;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mockapi")
public class MockApiController {

  private final CallMockApiHello callMockApiHello;
  private final CallMockApiHelloError callMockApiHelloError;

  private final MockApiInputMapper mockApiInputMapper;

  @GetMapping("/hello")
  @ResponseStatus(HttpStatus.OK)
  public MockApiResponse hello() {
    val mockApiHello = callMockApiHello.execute();
    return mockApiInputMapper.toResponse(mockApiHello);
  }

  @GetMapping("/hello-error")
  @ResponseStatus(HttpStatus.OK)
  public MockApiResponse helloError() {
    val mockApiHello = callMockApiHelloError.execute();
    return mockApiInputMapper.toResponse(mockApiHello);
  }
}
