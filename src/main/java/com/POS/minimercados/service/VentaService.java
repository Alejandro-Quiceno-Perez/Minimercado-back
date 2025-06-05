package com.POS.minimercados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.POS.minimercados.entity.Venta;
import com.POS.minimercados.repository.VentaRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVentaById(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta createVenta(@Valid Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> updateVenta(Long id, @Valid Venta venta) {
        return ventaRepository.findById(id).map(existing -> {
            venta.setId(existing.getId());
            return ventaRepository.save(venta);
        });
    }

    public boolean deleteVenta(Long id) {
        return ventaRepository.findById(id).map(v -> {
            ventaRepository.delete(v);
            return true;
        }).orElse(false);
    }
}
