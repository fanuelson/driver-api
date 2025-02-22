package com.lab.driverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DriverApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(DriverApiApplication.class, args);
  }
}
