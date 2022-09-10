package com.code.nityam.product.service.service;

import com.code.nityam.product.service.domain.Category;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> saveCategory(Category category);
    Page<Category> findAll(int page);
    Optional<Category> findCategoryByName(String name);
    Optional<Category> findCategoryByDescription(String description);
    Optional<Category> updateCategory(Category category);
    void deleteById(Long id);
    void delete(Category category);
}
