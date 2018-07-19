package com.cice.gestionproductos.msgestionproductos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue
    @Column(name = "idProducto")
    private Long idProducto;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

}
