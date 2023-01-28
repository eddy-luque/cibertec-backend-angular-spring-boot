package com.prestamos.pe.service;

import com.prestamos.pe.model.dto.PrestamoDto;
import com.prestamos.pe.model.dto.UserDto;
import com.prestamos.pe.model.entity.PrestamoEntity;
import com.prestamos.pe.security.user.User;

import java.util.List;

public interface UsuarioService {

    User obtenerUsuarioPorCorreo(String correo);
    User obtenerUsuarioPorId(Integer id );

    List<UserDto> listarTodosDto();

    List<User> listarTodos();

}
