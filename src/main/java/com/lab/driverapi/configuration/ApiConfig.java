package com.lab.driverapi.configuration;

import co.elastic.apm.attach.ElasticApmAttacher;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApiConfig {

  @Value("${elastic.apm.service_name}")
  private String serviceName;

  @Value("${elastic.apm.server_url}")
  private String serverUrl;

  @Value("${elastic.apm.application_packages}")
  private String applicationPackages;

  @PostConstruct
  public void init() {
    Map<String, String> apmProps = new HashMap<>();
    apmProps.put("service_name", serviceName);
    apmProps.put("server_url", serverUrl);
    apmProps.put("application_packages", applicationPackages);
    ElasticApmAttacher.attach(apmProps);
  }
}
