package com.prestamos.pe.controller;


import com.prestamos.pe.model.dto.PrestamoDto;
import com.prestamos.pe.model.dto.UserDto;
import com.prestamos.pe.security.user.User;
import com.prestamos.pe.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UsuarioService usuarioService;
    @Autowired
    private UserDetailsService userDetailsService;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    /*
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<UserDto>> listarTodos(Authentication authentication) {
    public ResponseEntity<List<User>> listarTodos(Authentication authentication) {
        UserDetails details = userDetailsService.loadUserByUsername(authentication.getName());
        if (details != null && (details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN")))) {
            System.out.println("LISTANDO!!!");
            // var lista = usuarioService.listarTodosDto() ;//.listarTodos(idUsuario);
            var lista = usuarioService.listarTodos() ;//.listarTodos(idUsuario);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
    */


    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> listarTodos(Authentication authentication) {
        UserDetails details = userDetailsService.loadUserByUsername(authentication.getName());
        if (details != null && (details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN")))) {
            System.out.println("LISTANDO!!!");
            var lista = usuarioService.listarTodosDto() ;//.listarTodos(idUsuario);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

}
