package com.tan.example.dto;

public class EnterpriseAddress {
  public String id;
  public String enterpriseId;
  public String addressId;

  public EnterpriseAddress(String enterpriseId, String addressId) {
    this.enterpriseId = enterpriseId;
    this.addressId = addressId;
  }

  public static EnterpriseAddress of(String enterpriseId, String addressId) {
    return new EnterpriseAddress(enterpriseId, addressId);
  }
}
