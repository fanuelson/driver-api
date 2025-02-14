package com.lab.driverapi.gateways.inputs.http.external;

import com.lab.driverapi.usecases.HealthCheckUseCase;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health-check")
public class HealthCheckController {

  private final HealthCheckUseCase healthCheckUseCase;

  @GetMapping
  public ResponseEntity<String> healthCheck() {
    val healthCheckMessage = healthCheckUseCase.execute();
    return ResponseEntity.ok(healthCheckMessage);
  }
}
