package com.code.nityam.product.service;

import com.code.nityam.product.service.domain.Category;
import com.code.nityam.product.service.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(CategoryService categoryService){
        return args->{
            categoryService.saveCategory(new Category(null,"Artifacts","Valuable artifacts"));
            categoryService.saveCategory(new Category(null,"Antiques","Valuable antiques"));
            categoryService.saveCategory(new Category(null,"Paintings","Valuable paintings"));
            categoryService.saveCategory(new Category(null,"Junk","Valuable junk"));
        };
    }

}
