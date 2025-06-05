package com.POS.minimercados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.POS.minimercados.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
