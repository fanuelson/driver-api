package com.lab.driverapi.gateways.inputs.kafka.mappers;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.inputs.kafka.resources.DriverResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverResourceKafkaConsumerMapper {

    Driver toDomain(DriverResource driverResource);
}
