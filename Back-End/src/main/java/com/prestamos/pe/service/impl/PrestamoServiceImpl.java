package com.prestamos.pe.service.impl;


import com.prestamos.pe.model.dto.PrestamoDto;
import com.prestamos.pe.model.entity.PrestamoEntity;
import com.prestamos.pe.repository.PrestamoObservacionRespository;
import com.prestamos.pe.repository.PrestamoRepository;
import com.prestamos.pe.service.PrestamoService;
import org.springframework.stereotype.Service;

import static com.prestamos.pe.model.dto.PrestamoDto.getPrestamoDtoList;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private  final PrestamoObservacionRespository prestamoObservacionRespository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository, PrestamoObservacionRespository prestamoObservacionRespository) {
        this.prestamoRepository = prestamoRepository;
        this.prestamoObservacionRespository = prestamoObservacionRespository;
    }

    @Override
    public List<PrestamoDto> listarTodos(int usuarioId) {
        List<PrestamoEntity> lista = null;
        if(usuarioId>0){
            lista = prestamoRepository.findPrestamoEntitiesByUsuarioId( usuarioId );
        }else{
            lista = prestamoRepository.findAll();
        }
        return  getPrestamoDtoList( lista );
    }

    @Override
    public PrestamoEntity Registrar(PrestamoEntity prestamoEntity) {
        return prestamoRepository.save( prestamoEntity );
    }

    @Override
    public Optional<PrestamoEntity> obtenerUno(int IdPrestamo) {
        return prestamoRepository.findById( IdPrestamo );
    }

}
