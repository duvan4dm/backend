package com.spa.citas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
// aqui se crean los getters y setters automaticos usando lombok
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    private String nombre;
    private String email;
    private String telefono;


}
