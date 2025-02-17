package com.lab.driverapi.gateways.outputs.http.mappers;

import com.lab.driverapi.domain.delayapi.DelayApiDelay;
import com.lab.driverapi.gateways.outputs.http.clients.resources.responses.DelayApiDelayResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DelayApiOutputMapper {
  DelayApiDelay toDomain(DelayApiDelayResponse delayApiDelayResponse);
}
