package com.tan.example.service.impl;

import com.tan.example.dto.Address;
import com.tan.example.entity.AddressEntity;
import com.tan.example.mapper.AddressMapper;
import com.tan.example.service.AddressInterface;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class AddressService implements AddressInterface {

  @Inject
  AddressMapper addressMapper;

  public Address createAddress(Address address) {
    AddressEntity addressEntity = this.addressMapper.toEntity(address);
    AddressEntity.persist(addressEntity);
    return this.addressMapper.toDto(addressEntity);
  }
}
