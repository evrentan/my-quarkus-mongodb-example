package com.tan.example.service;

import com.tan.example.entity.EnterpriseEntity;

import javax.validation.Valid;
import java.util.List;

public interface EnterpriseInterface {
  List<EnterpriseEntity> findAllEnterprises();

  EnterpriseEntity findEnterpriseById(String id);

  EnterpriseEntity createEnterprise(@Valid EnterpriseEntity enterpriseEntity);
}
