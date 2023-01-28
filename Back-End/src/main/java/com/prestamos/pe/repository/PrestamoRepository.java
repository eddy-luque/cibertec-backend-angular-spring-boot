package com.prestamos.pe.repository;


import com.prestamos.pe.model.entity.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Integer> {

    List<PrestamoEntity> findPrestamoEntitiesByUsuarioId( int usuarioId );



}
