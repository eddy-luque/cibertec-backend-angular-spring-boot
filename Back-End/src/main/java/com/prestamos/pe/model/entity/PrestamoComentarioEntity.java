package com.prestamos.pe.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prestamos.pe.enums.EstadoPrestamo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "prestamo_obs")
public class PrestamoComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable= false)
    private int id;

    private Date fecha;

    private  String comentario;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestamo_id")
    @JsonIgnore
    private PrestamoEntity prestamo;



}
