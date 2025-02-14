package com.lab.driverapi.gateways.inputs.http.mappers;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.inputs.http.resources.requests.DriverRequest;
import com.lab.driverapi.gateways.inputs.http.resources.responses.DriverResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverResourceMapper {

  DriverResponse toResponse(Driver driver);

  Driver toDomain(DriverRequest driverRequest);
}
