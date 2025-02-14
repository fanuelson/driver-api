package com.lab.driverapi.usecases;

import com.lab.driverapi.gateways.outputs.DriverDataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteDriverUseCase {

  private final DriverDataGateway driverDataGateway;

  public void execute(String id) {
    driverDataGateway.delete(id);
  }
}
