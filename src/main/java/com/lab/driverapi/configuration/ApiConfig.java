package com.lab.driverapi.configuration;

import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApiConfig {

    private final TimeLimiterRegistry timeLimiterRegistry;

    @PostConstruct
    public TimeLimiterRegistry crate() {
        System.out.println(timeLimiterRegistry);
        return timeLimiterRegistry;
    }
}
