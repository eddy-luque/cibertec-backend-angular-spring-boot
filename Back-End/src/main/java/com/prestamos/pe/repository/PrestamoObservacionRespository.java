package com.prestamos.pe.repository;

import com.prestamos.pe.model.entity.PrestamoComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoObservacionRespository extends JpaRepository<PrestamoComentarioEntity,Integer> {

    PrestamoComentarioEntity  findPrestamoComentarioEntityByPrestamoIdprestamo( int idPrestamo );
}
