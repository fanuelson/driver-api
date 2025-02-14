package com.lab.driverapi.builders;

import com.lab.driverapi.domain.Driver;

public class DriverBuilder {

  public static Driver VALID() {
    return Driver.builder().id("abc").name("any name").build();
  }
}
