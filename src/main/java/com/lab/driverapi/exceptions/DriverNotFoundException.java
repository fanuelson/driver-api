package com.lab.driverapi.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DriverNotFoundException extends ApiException {

  public DriverNotFoundException(String driverId) {
    super("Driver with id %s not found".formatted(driverId), HttpStatus.NOT_FOUND);
  }
}
