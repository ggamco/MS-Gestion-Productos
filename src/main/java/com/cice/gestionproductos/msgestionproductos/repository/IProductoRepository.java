package com.cice.gestionproductos.msgestionproductos.repository;

import com.cice.gestionproductos.msgestionproductos.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByIdUsuario(Long idUsuario);
    List<ProductoEntity> deleteByIdUsuario(Long idUsuario);
}
