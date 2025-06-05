package com.POS.minimercados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.POS.minimercados.entity.DetalleVenta;
import com.POS.minimercados.repository.DetalleVentaRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleVentaService {
       private final DetalleVentaRepository detalleVentaRepository;

       public List<DetalleVenta> getAllDetalles() {
              return detalleVentaRepository.findAll();
       }

       public Optional<DetalleVenta> getDetalleById(Long id) {
              return detalleVentaRepository.findById(id);
       }

       public DetalleVenta createDetalle(@Valid DetalleVenta detalleVenta) {
              return detalleVentaRepository.save(detalleVenta);
       }

       public Optional<DetalleVenta> updateDetalle(Long id, @Valid DetalleVenta detalleVenta) {
              return detalleVentaRepository.findById(id).map(existing -> {
                     detalleVenta.setId(existing.getId());
                     return detalleVentaRepository.save(detalleVenta);
              });
       }

       public boolean deleteDetalle(Long id) {
              return detalleVentaRepository.findById(id).map(d -> {
                     detalleVentaRepository.delete(d);
                     return true;
              }).orElse(false);
       }
}
