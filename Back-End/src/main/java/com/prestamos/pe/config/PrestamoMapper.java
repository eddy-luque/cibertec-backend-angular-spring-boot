package com.prestamos.pe.config;


import com.prestamos.pe.model.dto.PrestamoDto;
import com.prestamos.pe.model.entity.PrestamoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PrestamoMapper {

    PrestamoMapper INSTANCE = Mappers.getMapper(PrestamoMapper.class);

    List<PrestamoEntity> convierteListDtoToEntity(List<PrestamoDto> list);
    List<PrestamoDto> convierteListEntityToDto(List<PrestamoEntity> list);


}
