package com.POS.minimercados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.POS.minimercados.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
