package dev.jefferson.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jefferson.productapi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
