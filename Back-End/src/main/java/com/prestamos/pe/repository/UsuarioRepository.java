package com.prestamos.pe.repository;


import com.prestamos.pe.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String correo);

    // List<User> findUserByRoleContains(String rol);

    @Query("SELECT u FROM User u WHERE u.role = 'USER'")
    public List<User> findAlOnlyUsers();
    //List<User> findByRoleContainsIgnoreCase(String rol);

}
