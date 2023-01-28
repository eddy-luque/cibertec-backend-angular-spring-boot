package com.prestamos.pe.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
@Table(name = "cobranza")
public class CobranzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcobranza", nullable= false)
    private int idcobranza;

    private int nrocuota;

    private Date fechavencimiento;

    private  double montocuota;

    private Date fechapago;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_prestamo", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PrestamoEntity codigoprestamo;




}
