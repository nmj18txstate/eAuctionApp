package com.code.nityam.product.service.repo;

import com.code.nityam.product.service.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    @Override
    Optional<Category> findById(Long id);
    Optional<Category> findByCategoryName(String name);
    Optional<Category> findByCategoryDescription(String description);
}
