package com.lab.driverapi.gateways.outputs.mongodb;

import com.lab.driverapi.domain.Driver;
import java.util.Optional;

public interface DriverDataGateway {

  public Optional<Driver> findById(String id);

  public Driver save(Driver driver);

  public void delete(String id);
}
