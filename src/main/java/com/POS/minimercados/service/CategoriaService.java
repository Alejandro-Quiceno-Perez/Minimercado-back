package com.POS.minimercados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.POS.minimercados.entity.Category;
import com.POS.minimercados.repository.CategoryRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoryRepository categoriaRepository;

    public List<Category> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Category> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Category createCategoria(@Valid Category categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Category> updateCategoria(Long id, @Valid Category categoria) {
        return categoriaRepository.findById(id).map(existing -> {
            categoria.setId(existing.getId());
            return categoriaRepository.save(categoria);
        });
    }

    public boolean deleteCategoria(Long id) {
        return categoriaRepository.findById(id).map(cat -> {
            categoriaRepository.delete(cat);
            return true;
        }).orElse(false);
    }
}