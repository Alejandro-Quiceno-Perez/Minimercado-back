package com.POS.minimercados.controller;


import com.POS.minimercados.entity.DetalleVenta;
import com.POS.minimercados.repository.DetalleVentaRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaRepository detalleVentaRepository;

    @GetMapping
    public List<DetalleVenta> getAllDetalleVentas() {
        return detalleVentaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> createDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta) {
        return ResponseEntity.ok(detalleVentaRepository.save(detalleVenta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@PathVariable Long id, @Valid @RequestBody DetalleVenta detalleVenta) {
        return detalleVentaRepository.findById(id)
                .map(existing -> {
                    detalleVenta.setId(existing.getId());
                    return ResponseEntity.ok(detalleVentaRepository.save(detalleVenta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

