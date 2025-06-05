package com.POS.minimercados.controller;

import com.POS.minimercados.entity.Product;
import com.POS.minimercados.repository.ProductoRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepository productoRepository;

    @GetMapping
    public List<Product> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> createProducto(@Valid @RequestBody Product producto) {
        return ResponseEntity.ok(productoRepository.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProducto(@PathVariable Long id, @Valid @RequestBody Product producto) {
        return productoRepository.findById(id)
                .map(existing -> {
                    producto.setId(existing.getId());
                    return ResponseEntity.ok(productoRepository.save(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    
}
