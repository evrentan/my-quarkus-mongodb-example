package com.tan.example.mapper;

import com.tan.example.dto.DetailEnterprise;
import com.tan.example.entity.AddressEntity;
import com.tan.example.entity.EnterpriseEntity;
import org.bson.types.ObjectId;
import org.mapstruct.*;

import java.util.Objects;

@Mapper(componentModel = "cdi",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DetailEnterpriseMapper {

  @Mappings({
      @Mapping(target = "id", expression = "java(enterpriseEntity.id.toString())"),
      @Mapping(target = "name", source = "enterpriseEntity.name"),
      @Mapping(target = "webPage", source = "enterpriseEntity.webPage"),
      @Mapping(target = "address.id", expression = "java(addressEntity.id.toString())"),
      @Mapping(target = "address.country", source = "addressEntity.country"),
      @Mapping(target = "address.city", source = "addressEntity.city"),
      @Mapping(target = "address.district", source = "addressEntity.district"),
      @Mapping(target = "address.neighborhood", source = "addressEntity.neighborhood"),
      @Mapping(target = "address.streetName", source = "addressEntity.streetName"),
      @Mapping(target = "address.streetNumber", source = "addressEntity.streetNumber"),
      @Mapping(target = "address.houseNumber", source = "addressEntity.houseNumber"),
      @Mapping(target = "address.doorNumber", source = "addressEntity.doorNumber"),
      @Mapping(target = "address.postalCode", source = "addressEntity.postalCode"),
      @Mapping(target = "address.condoUnitId", source = "addressEntity.condoUnitId")
  })
  DetailEnterprise toDetailEnterprise(EnterpriseEntity enterpriseEntity, AddressEntity addressEntity);

  @Mappings({
      @Mapping(target = "id", ignore = true),
      @Mapping(target = "name", source = "detailEnterprise.name"),
      @Mapping(target = "webPage", source = "detailEnterprise.webPage")
  })
  EnterpriseEntity toEnterpriseEntity(DetailEnterprise detailEnterprise);

  @Mappings({
      @Mapping(target = "id", ignore = true),
      @Mapping(target = "country", source = "detailEnterprise.address.country"),
      @Mapping(target = "city", source = "detailEnterprise.address.city"),
      @Mapping(target = "district", source = "detailEnterprise.address.district"),
      @Mapping(target = "neighborhood", source = "detailEnterprise.address.neighborhood"),
      @Mapping(target = "streetName", source = "detailEnterprise.address.streetName"),
      @Mapping(target = "streetNumber", source = "detailEnterprise.address.streetNumber"),
      @Mapping(target = "houseNumber", source = "detailEnterprise.address.houseNumber"),
      @Mapping(target = "doorNumber", source = "detailEnterprise.address.doorNumber"),
      @Mapping(target = "postalCode", source = "detailEnterprise.address.postalCode"),
      @Mapping(target = "condoUnitId", source = "detailEnterprise.address.condoUnitId")
  })
  AddressEntity toAddressEntity(DetailEnterprise detailEnterprise);

  @AfterMapping
  default void setEnterpriseEntityId(DetailEnterprise detailEnterprise, @MappingTarget EnterpriseEntity enterpriseEntity) {
    if(Objects.nonNull(detailEnterprise.id))
      enterpriseEntity.id = new ObjectId(detailEnterprise.id);
  }

  @AfterMapping
  default void setAddressEntityId(DetailEnterprise detailEnterprise, @MappingTarget AddressEntity addressEntity) {
    if(Objects.nonNull(detailEnterprise.address) && Objects.nonNull(detailEnterprise.address.id))
      addressEntity.id = new ObjectId(detailEnterprise.address.id);
  }
}
