package com.tan.example.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "address")
public class AddressEntity extends PanacheMongoEntity {
  public String country;
  public String city;
  public String district;
  public String neighborhood;
  public String streetName;
  public String streetNumber;
  public String houseNumber;
  public String doorNumber;
  public String postalCode;
  public String condoUnitId;

  @Override
  public String toString() {
    return "AddressEntity{" +
        "country='" + country + '\'' +
        ", city='" + city + '\'' +
        ", district='" + district + '\'' +
        ", neighborhood='" + neighborhood + '\'' +
        ", streetName='" + streetName + '\'' +
        ", streetNumber='" + streetNumber + '\'' +
        ", houseNumber='" + houseNumber + '\'' +
        ", doorNumber='" + doorNumber + '\'' +
        ", postalCode='" + postalCode + '\'' +
        ", condoUnitId='" + condoUnitId + '\'' +
        '}';
  }
}
