package com.tan.example.service;

import com.tan.example.dto.Enterprise;
import com.tan.example.entity.EnterpriseEntity;
import com.tan.example.mapper.EnterpriseMapper;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class EnterpriseService implements EnterpriseInterface {

  @Inject
  EnterpriseMapper enterpriseMapper;

  public List<Enterprise> findAllEnterprises() {
    return this.enterpriseMapper.toDtoList(EnterpriseEntity.listAll());
  }

  public Enterprise findEnterpriseById(String id) {
    final ObjectId enterpriseId = new ObjectId(id);
    return this.enterpriseMapper.toDto(EnterpriseEntity.findById(enterpriseId));
  }

  public Enterprise createEnterprise(@Valid Enterprise enterprise) {
    EnterpriseEntity enterpriseEntity = this.enterpriseMapper.toEntity(enterprise);
    EnterpriseEntity.persist(enterpriseEntity);
    return this.enterpriseMapper.toDto(enterpriseEntity);
  }
}
