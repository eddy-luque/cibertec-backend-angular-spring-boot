package com.prestamos.pe.service.impl;

import com.prestamos.pe.model.dto.UserDto;
import com.prestamos.pe.model.entity.PrestamoEntity;
import com.prestamos.pe.repository.UsuarioRepository;
import com.prestamos.pe.security.user.User;
import com.prestamos.pe.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

// import static com.prestamos.pe.model.dto.PrestamoDto.getPrestamoDtoList;
import static com.prestamos.pe.model.dto.UserDto.getUserDtoList; //.model.dto.PrestamoDto.getPrestamoDtoList;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public User obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findUserByEmail(correo);
    }

    @Override
    public User obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public List<UserDto> listarTodosDto() {
        List<User> lista = null;
        // lista = usuarioRepository.findAll();
        //lista = usuarioRepository.findUserByRoleContains("USER"); // .findUserByRoleContains("USER");
        lista = usuarioRepository.findAlOnlyUsers(); // .findUserByRoleContains("USER");
        return getUserDtoList(lista);
    }

    @Override
    public List<User> listarTodos() {
        return usuarioRepository.findAll();
    }

    /*
    @Override
    public List<UserDto> listarTodos() {
        List<User> lista = null;
        lista = usuarioRepository.findAll();
        return getUserDtoList(lista);
    }
    */



}
