package com.POS.minimercados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.POS.minimercados.entity.Product;

public interface ProductoRepository extends JpaRepository<Product, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
