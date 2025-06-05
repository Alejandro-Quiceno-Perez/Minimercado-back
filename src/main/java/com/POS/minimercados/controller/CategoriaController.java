package com.POS.minimercados.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.POS.minimercados.entity.Category;
import com.POS.minimercados.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

       private final CategoryRepository categoriaRepository;

       @GetMapping
       public List<Category> getAllCategorias() {
              return categoriaRepository.findAll();
       }

       @PostMapping
       public ResponseEntity<Category> createCategoria(@Valid @RequestBody Category categoria) {
              return ResponseEntity.ok(categoriaRepository.save(categoria));
       }

       @PutMapping("/{id}")
       public ResponseEntity<Category> updateCategoria(@PathVariable Long id, @Valid @RequestBody Category categoria) {
              return categoriaRepository.findById(id)
                            .map(existing -> {
                                   categoria.setId(existing.getId());
                                   return ResponseEntity.ok(categoriaRepository.save(categoria));
                            })
                            .orElse(ResponseEntity.notFound().build());
       }

}
