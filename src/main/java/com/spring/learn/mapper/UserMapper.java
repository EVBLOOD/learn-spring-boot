package com.spring.learn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.spring.learn.model.UserEntity;
import com.spring.learn.ressources.NewUserRequest;
import com.spring.learn.ressources.ServeUser;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source   = "fullName", target   = "userFullName", defaultValue  = "name")
    ServeUser EntityToDto(UserEntity user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rule", ignore = true)
    @Mapping(target = "locked", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "password", ignore = true)
    @InheritInverseConfiguration
    UserEntity DtoToEntity(ServeUser toServe);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rule", ignore = true)
    @Mapping(target = "locked", ignore = true)
    @Mapping(target = "token", ignore = true)
    UserEntity DtoRegisterToEntity(NewUserRequest newone);
}
