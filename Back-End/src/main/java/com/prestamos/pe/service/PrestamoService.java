package com.prestamos.pe.service;


import com.prestamos.pe.model.dto.PrestamoDto;
import com.prestamos.pe.model.entity.PrestamoEntity;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {

    List<PrestamoDto> listarTodos(int usuarioId);

    PrestamoEntity Registrar(PrestamoEntity prestamoEntity);


    Optional<PrestamoEntity> obtenerUno(int IdPrestamo );

}
