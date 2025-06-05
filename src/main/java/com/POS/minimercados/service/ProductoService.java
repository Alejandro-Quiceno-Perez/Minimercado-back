package com.POS.minimercados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.POS.minimercados.entity.Product;
import com.POS.minimercados.repository.ProductoRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
       private final ProductoRepository productoRepository;

       public List<Product> getAllProductos() {
              return productoRepository.findAll();
       }

       public Optional<Product> getProductoById(Long id) {
              return productoRepository.findById(id);
       }

       public Product createProducto(@Valid Product producto) {
              return productoRepository.save(producto);
       }

       public Optional<Product> updateProducto(Long id, @Valid Product producto) {
              return productoRepository.findById(id).map(existing -> {
                     producto.setId(existing.getId());
                     return productoRepository.save(producto);
              });
       }

       public boolean deleteProducto(Long id) {
              return productoRepository.findById(id).map(p -> {
                     productoRepository.delete(p);
                     return true;
              }).orElse(false);
       }
}
