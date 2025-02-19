package com.lab.driverapi.usecases;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.exceptions.DriverNotFoundException;
import com.lab.driverapi.gateways.outputs.mongodb.DriverDataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetDriverByIdUseCase {

  private final DriverDataGateway driverDataGateway;

  public Driver execute(String id) {
    return driverDataGateway.findById(id).orElseThrow(() -> new DriverNotFoundException(id));
  }
}
