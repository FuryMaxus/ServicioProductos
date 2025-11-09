package com.ecoMarket.servicioProductos.repository;

import com.ecoMarket.servicioProductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    @Query("SELECT p FROM Producto p WHERE " +
            "(:category IS NULL OR p.category = :category) AND " +
            "(:brand IS NULL OR p.brand = :brand) AND " +
            "(:productCondition IS NULL OR p.productCondition = :productCondition)"
    )
    List<Producto> buscarPorFiltro(
            @Param("category") String categoria,
            @Param("brand") String marca,
            @Param("productCondition") String condition
    );
}
