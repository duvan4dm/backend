package com.spa.citas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;


@Entity
@Table(name = "servicios")
@Data
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    private String nombre;
    private String descripcion;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    private BigDecimal precio;

}
