package com.POS.minimercados.controller;

import com.POS.minimercados.entity.Proveedor;
import com.POS.minimercados.repository.ProveedorRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

       private final ProveedorRepository proveedorRepository;

       @GetMapping
       public List<Proveedor> getAllProveedores() {
              return proveedorRepository.findAll();
       }

       @PostMapping
       public ResponseEntity<Proveedor> createProveedor(@Valid @RequestBody Proveedor proveedor) {
              return ResponseEntity.ok(proveedorRepository.save(proveedor));
       }

       @PutMapping("/{id}")
       public ResponseEntity<Proveedor> updateProveedor(@PathVariable Long id,
                     @Valid @RequestBody Proveedor proveedor) {
              return proveedorRepository.findById(id)
                            .map(existing -> {
                                   proveedor.setId(existing.getId());
                                   return ResponseEntity.ok(proveedorRepository.save(proveedor));
                            })
                            .orElse(ResponseEntity.notFound().build());
       }

}
