package com.prestamos.pe.model.dto;


import com.prestamos.pe.config.PrestamoMapper;
import com.prestamos.pe.enums.EstadoPrestamo;
import com.prestamos.pe.model.entity.PrestamoEntity;
import com.prestamos.pe.security.user.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDto {

    private int idprestamo;
     private  double monto;
     private  double interes;
     private  int cuotas;
     private Date fechaprestamo;
     // private User usuario;

    //@Enumerated(EnumType.STRING)
    //private EstadoPrestamo estado;

    public static List<PrestamoDto> getPrestamoDtoList(List<PrestamoEntity> list) {
        return PrestamoMapper.INSTANCE.convierteListEntityToDto( list );
    }

}
