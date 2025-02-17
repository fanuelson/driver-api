package com.lab.driverapi.gateways.inputs.http.external;

import com.lab.driverapi.gateways.inputs.http.mappers.DelayApiInputMapper;
import com.lab.driverapi.gateways.inputs.http.resources.responses.DelayApiResponse;
import com.lab.driverapi.usecases.CallDelayApiDelay;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delay")
public class DelayApiController {

  private final CallDelayApiDelay callDelayApiDelay;

  private final DelayApiInputMapper delayApiInputMapper;

  @GetMapping("/{delay}")
  @ResponseStatus(HttpStatus.OK)
  public DelayApiResponse delay(@PathVariable() final Long delay) {
    val delayApiHello = callDelayApiDelay.execute(delay);
    return delayApiInputMapper.toResponse(delayApiHello);
  }
}
