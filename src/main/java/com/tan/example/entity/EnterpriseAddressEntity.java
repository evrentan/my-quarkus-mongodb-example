package com.tan.example.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import javax.validation.constraints.NotNull;

@MongoEntity(collection = "enterprise_address")
public class EnterpriseAddressEntity extends PanacheMongoEntity {
  @NotNull
  public String enterpriseId;
  @NotNull
  public String addressId;
}
