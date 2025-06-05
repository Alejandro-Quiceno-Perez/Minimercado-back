package com.POS.minimercados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.POS.minimercados.entity.Proveedor;
import com.POS.minimercados.repository.ProveedorRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
       private final ProveedorRepository proveedorRepository;

       public List<Proveedor> getAllProveedores() {
              return proveedorRepository.findAll();
       }

       public Optional<Proveedor> getProveedorById(Long id) {
              return proveedorRepository.findById(id);
       }

       public Proveedor createProveedor(@Valid Proveedor proveedor) {
              return proveedorRepository.save(proveedor);
       }

       public Optional<Proveedor> updateProveedor(Long id, @Valid Proveedor proveedor) {
              return proveedorRepository.findById(id).map(existing -> {
                     proveedor.setId(existing.getId());
                     return proveedorRepository.save(proveedor);
              });
       }

       public boolean deleteProveedor(Long id) {
              return proveedorRepository.findById(id).map(p -> {
                     proveedorRepository.delete(p);
                     return true;
              }).orElse(false);
       }
}
