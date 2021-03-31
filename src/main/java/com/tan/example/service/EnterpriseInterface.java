package com.tan.example.service;

import com.tan.example.dto.Enterprise;

import javax.validation.Valid;
import java.util.List;

public interface EnterpriseInterface {
  List<Enterprise> findAllEnterprises();

  Enterprise findEnterpriseById(String id);

  Enterprise createEnterprise(@Valid Enterprise enterpriseEntity);
}
