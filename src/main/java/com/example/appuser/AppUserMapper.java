package com.example.appuser;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
@Mapper(componentModel = "spring")
@Component
public interface AppUserMapper {
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    AppUser appUsertoAppUserDTO(AppUserDTO appUserDTO);
}
