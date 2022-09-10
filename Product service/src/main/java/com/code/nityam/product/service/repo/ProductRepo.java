package com.code.nityam.product.service.repo;

import com.code.nityam.product.service.domain.Category;
import com.code.nityam.product.service.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long id);
    Optional<Page<Product>> findAllByShortDescription(String description,Pageable pageable);
    Optional<Page<Product>> findAllByDetailDescription(String description, Pageable pageable);
    Optional<Page<Product>> findByCategory(Category category,Pageable pageable);
    Optional<Page<Product>> findByStartingPrice(Double price,Pageable pageable);
    Optional<Page<Product>> findByEndingPrice(Double price,Pageable pageable);
    Optional<Page<Product>> findByBidEndDate(Date date,Pageable pageable);
}
