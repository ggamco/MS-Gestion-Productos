package com.cice.gestionproductos.msgestionproductos.service;

import com.cice.gestionproductos.msgestionproductos.web.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> getAllProductos();
    List<ProductoDTO> getProductoByIdUsuario(long idUsuario);
    ProductoDTO crearProductoByUsuario(long idUsuario, ProductoDTO producto);
    List<ProductoDTO> eliminarProductosByUsuario(long idUsuario);

}
