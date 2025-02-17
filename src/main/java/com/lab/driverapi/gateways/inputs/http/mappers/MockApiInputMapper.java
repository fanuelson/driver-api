package com.lab.driverapi.gateways.inputs.http.mappers;

import com.lab.driverapi.domain.mockapi.MockApiHello;
import com.lab.driverapi.gateways.inputs.http.resources.responses.MockApiResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MockApiInputMapper {

  MockApiResponse toResponse(MockApiHello mockApiHello);
}
