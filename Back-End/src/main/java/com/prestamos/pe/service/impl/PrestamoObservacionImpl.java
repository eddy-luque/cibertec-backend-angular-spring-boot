package com.prestamos.pe.service.impl;

import com.prestamos.pe.model.entity.PrestamoComentarioEntity;
import com.prestamos.pe.repository.PrestamoObservacionRespository;
import com.prestamos.pe.service.PrestamoObservacionService;
import org.springframework.stereotype.Service;

@Service
public class PrestamoObservacionImpl implements PrestamoObservacionService {

    private final PrestamoObservacionRespository prestamoObservacionRespository;

    public PrestamoObservacionImpl(PrestamoObservacionRespository prestamoObservacionRespository) {
        this.prestamoObservacionRespository = prestamoObservacionRespository;
    }

    @Override
    public PrestamoComentarioEntity getPrestamoObservado(int prestamo) {
        return this.prestamoObservacionRespository.findPrestamoComentarioEntityByPrestamoIdprestamo( prestamo );
    }

    @Override
    public PrestamoComentarioEntity observarPrestamo(PrestamoComentarioEntity prestamoComentarioEntity) {
        return this.prestamoObservacionRespository.save( prestamoComentarioEntity );
    }
}
