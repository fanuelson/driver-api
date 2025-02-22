package com.lab.driverapi.configuration.clients;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "driverapi.clients", ignoreInvalidFields = true)
@Configuration
public class ClientsProps {

  private DelayApiClient delayApiClient;

  @Data
  public static class DelayApiClient {
    private String url;
  }
}
