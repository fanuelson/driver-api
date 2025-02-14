package com.lab.driverapi.gateways.inputs.kafka.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverResource {
    private String id;
    private String name;
}
