package com.prestamos.pe.service;

import com.prestamos.pe.model.entity.PrestamoComentarioEntity;

public interface PrestamoObservacionService {

    PrestamoComentarioEntity getPrestamoObservado( int prestamo );

    PrestamoComentarioEntity observarPrestamo( PrestamoComentarioEntity prestamoComentarioEntity );


}
