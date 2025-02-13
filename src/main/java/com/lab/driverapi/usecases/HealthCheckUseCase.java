package com.lab.driverapi.usecases;

import org.springframework.stereotype.Service;

@Service
public class HealthCheckUseCase {

  public String execute() {
    return "API is running";
  }
}
