package com.lab.driverapi.usecases;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.outputs.mongodb.DriverDataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateDriverUseCase {

  private final DriverDataGateway driverDataGateway;

  public Driver execute(Driver driver) {
    return driverDataGateway.save(driver);
  }
}
