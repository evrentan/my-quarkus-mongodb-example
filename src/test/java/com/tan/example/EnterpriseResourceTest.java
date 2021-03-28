package com.tan.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class EnterpriseResourceTest {

  @Test
  public void testEnterpriseEndpoint() {
    given()
        .when().get("/enterprise")
        .then()
        .statusCode(200);
  }

}