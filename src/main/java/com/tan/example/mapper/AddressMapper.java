package com.tan.example.mapper;

import com.tan.example.dto.Address;
import com.tan.example.entity.AddressEntity;
import org.bson.types.ObjectId;
import org.mapstruct.*;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "cdi",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

  @Mapping(target = "id", ignore = true)
  AddressEntity toEntity(Address address);

  @Mapping(target = "id", expression = "java(addressEntity.id.toString())")
  Address toDto(AddressEntity addressEntity);

  List<AddressEntity> toEntityList(List<Address> addressList);

  List<Address> toDtoList(List<AddressEntity> addressEntityList);

  @AfterMapping
  default void setEntityId(Address address, @MappingTarget AddressEntity addressEntity) {
    if(Objects.nonNull(address.id))
      addressEntity.id = new ObjectId(address.id);
  }
}
