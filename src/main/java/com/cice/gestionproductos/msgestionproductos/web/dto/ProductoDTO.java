package com.cice.gestionproductos.msgestionproductos.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    private Long idProducto;
    private Long idUsuario;
    private String nombre;
    private String codigo;

}
