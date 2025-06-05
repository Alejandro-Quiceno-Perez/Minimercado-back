package com.POS.minimercados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.POS.minimercados.entity.Category;



public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
