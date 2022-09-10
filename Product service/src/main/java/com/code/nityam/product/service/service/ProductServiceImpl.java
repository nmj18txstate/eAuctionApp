package com.code.nityam.product.service.service;

import com.code.nityam.product.service.domain.Category;
import com.code.nityam.product.service.domain.Product;
import com.code.nityam.product.service.repo.CategoryRepo;
import com.code.nityam.product.service.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    @Override
    public Optional<Product> saveProduct(Product product) {
        return Optional.of(productRepo.save(product));
    }

    @Override
    public Optional<Page<Product>> findProductByShortDescription(String description, int pageNumber) {
        return productRepo.findAllByShortDescription(description, PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Product>> findProductByDetailDescription(String description, int pageNumber) {
        return productRepo.findAllByDetailDescription(description,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Product>> findProductByCategory(String categoryName, int pageNumber) {
        Optional<Category> category = categoryRepo.findByCategoryName(categoryName);
        return productRepo.findByCategory(category.get(),PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Product>> findProductByStartingPrice(Double price, int pageNumber) {
        return productRepo.findByStartingPrice(price,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Product>> findProductByEndingPrice(Double price, int pageNumber) {
        return productRepo.findByEndingPrice(price,PageRequest.of(pageNumber,30));
    }

    @Override
    public Optional<Page<Product>> findProductByBidEndDate(Date date, int pageNumber) {
        return productRepo.findByBidEndDate(date,PageRequest.of(pageNumber,30));
    }

    @Override
    @Transactional
    public Optional<Product> updateProduct(Product product) {
        Optional<Product> prod = productRepo.findById(product.getId());
        if (prod.isPresent()){
            prod.get().setProductName(product.getProductName());
            prod.get().setShortDescription(product.getShortDescription());
            prod.get().setDetailDescription(product.getDetailDescription());
            prod.get().setDetailDescription(product.getDetailDescription());
            prod.get().setCategory(product.getCategory());
            prod.get().setStartingPrice(product.getStartingPrice());
            prod.get().setEndingPrice(product.getEndingPrice());
            prod.get().setBidEndDate(product.getBidEndDate());
        }
        return prod;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
}
