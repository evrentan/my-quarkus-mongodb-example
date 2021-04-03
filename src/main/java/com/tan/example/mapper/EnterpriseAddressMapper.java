package com.tan.example.mapper;

import com.tan.example.dto.EnterpriseAddress;
import com.tan.example.entity.EnterpriseAddressEntity;
import org.bson.types.ObjectId;
import org.mapstruct.*;

import java.util.Objects;

@Mapper(componentModel = "cdi",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnterpriseAddressMapper {

  @Mappings({
      @Mapping(target = "id", expression = "java(enterpriseAddressEntity.id.toString())"),
      @Mapping(source = "enterpriseAddressEntity.enterpriseId", target = "enterpriseId"),
      @Mapping(source = "enterpriseAddressEntity.addressId", target = "addressId")
  })
  EnterpriseAddress toDto(EnterpriseAddressEntity enterpriseAddressEntity);

  @Mappings({
      @Mapping(target = "id", ignore = true),
      @Mapping(source = "enterpriseAddress.enterpriseId", target = "enterpriseId"),
      @Mapping(source = "enterpriseAddress.addressId", target = "addressId")
  })
  EnterpriseAddressEntity toEntity(EnterpriseAddress enterpriseAddress);

  @AfterMapping
  default void setEntityId(EnterpriseAddress enterpriseAddress, @MappingTarget EnterpriseAddressEntity enterpriseAddressEntity) {
    if(Objects.nonNull(enterpriseAddress.id))
      enterpriseAddressEntity.id = new ObjectId(enterpriseAddress.id);
  }
}
