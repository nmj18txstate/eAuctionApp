package com.code.nityam.product.service.service;

import com.code.nityam.product.service.domain.Product;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.Optional;

public interface ProductService {
    Optional<Product> saveProduct(Product product);
    Optional<Page<Product>> findProductByShortDescription(String description,int pageNumber);
    Optional<Page<Product>> findProductByDetailDescription(String description,int pageNumber);
    Optional<Page<Product>> findProductByCategory(String categoryName,int pageNumber);
    Optional<Page<Product>> findProductByStartingPrice(Double price,int pageNumber);
    Optional<Page<Product>> findProductByEndingPrice(Double price,int pageNumber);
    Optional<Page<Product>> findProductByBidEndDate(Date date, int pageNumber);
    Optional<Product> updateProduct(Product product);
    void deleteProductById(Long id);
    void deleteProduct(Product product);
 }
