package com.tan.example.service;

import com.tan.example.entity.EnterpriseEntity;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class EnterpriseService implements EnterpriseInterface {
  public List<EnterpriseEntity> findAllEnterprises() {
    return EnterpriseEntity.listAll();
  }

  public EnterpriseEntity findEnterpriseById(String id) {
    final ObjectId enterpriseId = new ObjectId(id);
    return EnterpriseEntity.findById(enterpriseId);
  }

  public EnterpriseEntity createEnterprise(@Valid EnterpriseEntity enterpriseEntity) {
    EnterpriseEntity.persist(enterpriseEntity);
    return  enterpriseEntity;
  }
}
