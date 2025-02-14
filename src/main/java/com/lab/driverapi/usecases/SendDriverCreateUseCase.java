package com.lab.driverapi.usecases;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.outputs.SendDriverCreateGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendDriverCreateUseCase {

  private final SendDriverCreateGateway sendDriverCreateGateway;

  public void execute(final Driver driver) {
    sendDriverCreateGateway.send(driver);
  }
}
