package com.POS.minimercados.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.POS.minimercados.entity.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
       // Aquí puedes agregar métodos personalizados si es necesario
}
