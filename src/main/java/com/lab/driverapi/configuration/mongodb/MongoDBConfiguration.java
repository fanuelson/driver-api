package com.lab.driverapi.configuration.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.lab.driverapi.gateways.outputs.mongodb"})
public class MongoDBConfiguration {}
