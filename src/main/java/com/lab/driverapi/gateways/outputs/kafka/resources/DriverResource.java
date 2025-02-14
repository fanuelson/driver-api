package com.lab.driverapi.gateways.outputs.kafka.resources;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverResource {
    private String id;
    private String name;
}
