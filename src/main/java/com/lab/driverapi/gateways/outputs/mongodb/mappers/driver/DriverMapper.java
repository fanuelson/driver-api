package com.lab.driverapi.gateways.outputs.mongodb.mappers.driver;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.outputs.mongodb.documents.DriverDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {

  Driver toDomain(DriverDocument driverDocument);

  DriverDocument toDocument(Driver driver);
}
