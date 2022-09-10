package com.code.nityam.product.service.service;

import com.code.nityam.product.service.domain.Category;
import com.code.nityam.product.service.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService{
    private final CategoryRepo categoryRepo;
    @Override
    public Optional<Category> saveCategory(Category category) {
        return Optional.of(categoryRepo.save(category));
    }

    @Override
    public Page<Category> findAll(int page) {
        return categoryRepo.findAll(PageRequest.of(page,30));
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return categoryRepo.findByCategoryName(name);
    }

    @Override
    public Optional<Category> findCategoryByDescription(String description) {
        return categoryRepo.findByCategoryDescription(description);
    }

    @Override
    public Optional<Category> updateCategory(Category category) {
        Optional<Category> cat = categoryRepo.findById(category.getId());
        if (cat.isPresent()){
            cat.get().setCategoryName(category.getCategoryName());
            cat.get().setCategoryDescription(category.getCategoryDescription());
        }
        return cat;
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public void delete(Category category) {
        categoryRepo.delete(category);
    }
}
