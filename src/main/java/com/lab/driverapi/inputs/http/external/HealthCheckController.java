package com.lab.driverapi.inputs.http.external;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthCheckController {
  @GetMapping
  public ResponseEntity<String> healthCheck() {
    return ResponseEntity.ok("API is running");
  }
}
