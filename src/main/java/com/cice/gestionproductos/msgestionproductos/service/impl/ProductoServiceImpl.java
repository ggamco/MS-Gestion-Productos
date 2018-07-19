package com.cice.gestionproductos.msgestionproductos.service.impl;

import com.cice.gestionproductos.msgestionproductos.entity.ProductoEntity;
import com.cice.gestionproductos.msgestionproductos.repository.IProductoRepository;
import com.cice.gestionproductos.msgestionproductos.service.IProductoService;
import com.cice.gestionproductos.msgestionproductos.web.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getAllProductos() {
        List<ProductoDTO> collect = productoRepository.findAll()
                .stream()
                .map(
                        entity -> new ProductoDTO(
                                entity.getIdProducto(),
                                entity.getIdUsuario(),
                                entity.getNombre(),
                                entity.getCodigo()
                        )
                ).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ProductoDTO> getProductoByIdUsuario(long idUsuario) {
        List<ProductoDTO> collect = productoRepository.findByIdUsuario(idUsuario)
                .stream()
                .map(entity -> new ProductoDTO(
                        entity.getIdProducto(),
                        entity.getIdUsuario(),
                        entity.getNombre(),
                        entity.getCodigo()
                )).collect(Collectors.toList());
        return collect;
    }

    @Override
    public ProductoDTO crearProductoByUsuario(long idUsuario, ProductoDTO producto) {
        ProductoEntity entity = new ProductoEntity(
                null,
                idUsuario,
                producto.getNombre(),
                producto.getCodigo()
        );
        ProductoEntity resultado = productoRepository.save(entity);

        return new ProductoDTO(
                resultado.getIdProducto(),
                resultado.getIdUsuario(),
                resultado.getNombre(),
                resultado.getCodigo()
        );
    }

    @Override
    public List<ProductoDTO> eliminarProductosByUsuario(long idUsuario) {
        List<ProductoEntity> productoEliminados = productoRepository.deleteByIdUsuario(idUsuario);
        return productoEliminados.stream().map(entity -> new ProductoDTO(
                entity.getIdProducto(),
                entity.getIdUsuario(),
                entity.getNombre(),
                entity.getCodigo()
        )).collect(Collectors.toList());
    }
}
