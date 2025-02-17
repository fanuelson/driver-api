package com.lab.driverapi.gateways.inputs.http.mappers;

import com.lab.driverapi.domain.delayapi.DelayApiDelay;
import com.lab.driverapi.gateways.inputs.http.resources.responses.DelayApiResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DelayApiInputMapper {

  DelayApiResponse toResponse(DelayApiDelay delayApiDelay);
}
