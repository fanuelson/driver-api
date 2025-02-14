package com.lab.driverapi.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Driver {
    private String id;
    private String name;
}
