package com.POS.minimercados.controller;


import com.POS.minimercados.entity.Venta;
import com.POS.minimercados.repository.VentaRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaRepository ventaRepository;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@Valid @RequestBody Venta venta) {
        return ResponseEntity.ok(ventaRepository.save(venta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @Valid @RequestBody Venta venta) {
        return ventaRepository.findById(id)
                .map(existing -> {
                    venta.setId(existing.getId());
                    return ResponseEntity.ok(ventaRepository.save(venta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    
}
