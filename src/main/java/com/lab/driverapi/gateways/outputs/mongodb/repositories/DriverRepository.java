package com.lab.driverapi.gateways.outputs.mongodb.repositories;

import com.lab.driverapi.gateways.outputs.mongodb.documents.DriverDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<DriverDocument, String> {}
