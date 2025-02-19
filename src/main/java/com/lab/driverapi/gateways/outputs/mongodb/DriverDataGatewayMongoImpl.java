package com.lab.driverapi.gateways.outputs.mongodb;

import com.lab.driverapi.domain.Driver;
import com.lab.driverapi.gateways.outputs.mongodb.mappers.driver.DriverMapper;
import com.lab.driverapi.gateways.outputs.mongodb.repositories.DriverRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DriverDataGatewayMongoImpl implements DriverDataGateway {

  private final DriverRepository driverRepository;

  private final DriverMapper driverMapper;

  public Optional<Driver> findById(final String id) {
    return driverRepository.findById(id).map(driverMapper::toDomain);
  }

  public Driver save(final Driver driver) {
    val driverDocument = driverMapper.toDocument(driver);
    val driverDocumentSaved = driverRepository.save(driverDocument);
    return driverMapper.toDomain(driverDocumentSaved);
  }

  public void delete(final String id) {
    driverRepository.deleteById(id);
  }
}
