package com.lab.driverapi.gateways.outputs.kafka.mappers;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.outputs.kafka.resources.DriverResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverResourceKafkaMapper {

  DriverResource toResource(Driver driver);

  Driver toDomain(DriverResource driverResource);
}
