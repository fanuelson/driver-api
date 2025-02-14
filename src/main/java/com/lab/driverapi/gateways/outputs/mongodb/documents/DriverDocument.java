package com.lab.driverapi.gateways.outputs.mongodb.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("driver")
public class DriverDocument {
  @MongoId private String id;

  private String name;
}
