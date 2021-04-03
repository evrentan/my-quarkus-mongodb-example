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
      @Mapping(source = "enterpriseEntity.name", target = "name"),
      @Mapping(source = "enterpriseEntity.webPage", target = "webPage"),
      @Mapping(target = "address.id", expression = "java(addressEntity.id.toString())"),
      @Mapping(source = "addressEntity.country", target = "address.country"),
      @Mapping(source = "addressEntity.city", target = "address.city"),
      @Mapping(source = "addressEntity.district", target = "address.district"),
      @Mapping(source = "addressEntity.neighborhood", target = "address.neighborhood"),
      @Mapping(source = "addressEntity.streetName", target = "address.streetName"),
      @Mapping(source = "addressEntity.streetNumber", target = "address.streetNumber"),
      @Mapping(source = "addressEntity.houseNumber", target = "address.houseNumber"),
      @Mapping(source = "addressEntity.doorNumber", target = "address.doorNumber"),
      @Mapping(source = "addressEntity.postalCode", target = "address.postalCode"),
      @Mapping(source = "addressEntity.condoUnitId", target = "address.condoUnitId")
  })
  DetailEnterprise toDetailEnterprise(EnterpriseEntity enterpriseEntity, AddressEntity addressEntity);

  @Mappings({
      @Mapping(target = "id", ignore = true),
      @Mapping(source = "detailEnterprise.name", target = "name"),
      @Mapping(source = "detailEnterprise.webPage", target = "webPage")
  })
  EnterpriseEntity toEnterpriseEntity(DetailEnterprise detailEnterprise);

  @Mappings({
      @Mapping(target = "id", ignore = true),
      @Mapping(source = "detailEnterprise.address.country", target = "country"),
      @Mapping(source = "detailEnterprise.address.city", target = "city"),
      @Mapping(source = "detailEnterprise.address.district", target = "district"),
      @Mapping(source = "detailEnterprise.address.neighborhood", target = "neighborhood"),
      @Mapping(source = "detailEnterprise.address.streetName", target = "streetName"),
      @Mapping(source = "detailEnterprise.address.streetNumber", target = "streetNumber"),
      @Mapping(source = "detailEnterprise.address.houseNumber", target = "houseNumber"),
      @Mapping(source = "detailEnterprise.address.doorNumber", target = "doorNumber"),
      @Mapping(source = "detailEnterprise.address.postalCode", target = "postalCode"),
      @Mapping(source = "detailEnterprise.address.condoUnitId", target = "condoUnitId")
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
