package com.lab.driverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableFeignClients
@SpringBootApplication
@EnableAsync
@EnableRetry
public class DriverApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverApiApplication.class, args);
	}

}
