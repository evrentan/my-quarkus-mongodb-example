package com.tan.example.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;

@MongoEntity(collection = "enterprise")
public class EnterpriseEntity extends PanacheMongoEntity {

  @NotNull
  @Size(min = 3, max = 50)
  public String name;
  public String webPage;

  public static EnterpriseEntity findRandom() {
    final long enterpriseCount = EnterpriseEntity.count();
    Random random = new Random();
    int randomHero = random.nextInt((int) enterpriseCount);
    return EnterpriseEntity.findAll().page(randomHero, 1).firstResult();
  }

  @Override
  public String toString() {
    return "EnterpriseEntity{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", webPage='" + webPage + '\'' +
        '}';
  }
}
