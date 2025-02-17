package com.lab.driverapi.gateways.outputs.http.mappers;

import com.lab.driverapi.domain.mockapi.MockApiHello;
import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.MockApiResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MockApiMapper {
  MockApiHello toDomain(MockApiResponse mockApiResponse);
}
