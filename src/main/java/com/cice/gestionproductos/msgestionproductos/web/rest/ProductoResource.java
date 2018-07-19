package com.cice.gestionproductos.msgestionproductos.web.rest;

import com.cice.gestionproductos.msgestionproductos.service.IProductoService;
import com.cice.gestionproductos.msgestionproductos.web.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class ProductoResource {

    @Autowired
    IProductoService productoService;

    @RequestMapping(value = "producto", method = RequestMethod.GET)
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @RequestMapping(value = "producto/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductoDTO>> getProductosByIdUsuario(@PathVariable Long idUsuario){
        List<ProductoDTO> productoByIdUsuario = productoService.getProductoByIdUsuario(idUsuario);
        return ResponseEntity.ok(productoByIdUsuario);
    }

    @RequestMapping(value = "producto/{idUsuario}", method = RequestMethod.POST)
    public ResponseEntity<Void> crearProductoParaUsuario(
            @RequestBody ProductoDTO productoDTO,
            @PathVariable Long idUsuario) {
        productoService.crearProductoByUsuario(idUsuario, productoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "producto/{idUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<List<ProductoDTO>> eliminarProductosByIdUsuario(@PathVariable Long idUsuario){
        List<ProductoDTO> productoEliminados = productoService.eliminarProductosByUsuario(idUsuario);
        return ResponseEntity.ok(productoEliminados);
    }

}
