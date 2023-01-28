package com.prestamos.pe.config;

import com.prestamos.pe.model.dto.PrestamoDto;
import com.prestamos.pe.model.dto.UserDto;
import com.prestamos.pe.model.entity.PrestamoEntity;
import com.prestamos.pe.security.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    List<User> convierteListDtoToEntity(List<UserDto> list);
    List<UserDto> convierteListEntityToDto(List<User> list);

}
