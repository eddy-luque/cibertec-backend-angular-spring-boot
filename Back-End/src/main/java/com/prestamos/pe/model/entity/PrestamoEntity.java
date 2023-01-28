package com.prestamos.pe.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prestamos.pe.security.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
@Table(name = "prestamo")
public class PrestamoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprestamo", nullable= false)
    private int idprestamo;
    private  double monto;

    private  double interes;

    private  int cuotas;

    private Date fechaprestamo;

    //@Enumerated(EnumType.STRING)
    //private EstadoPrestamo estado;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User usuario;


}
