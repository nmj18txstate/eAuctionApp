package com.code.nityam.product.service.controller;

import com.code.nityam.product.service.domain.Product;
import com.code.nityam.product.service.service.CategoryService;
import com.code.nityam.product.service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    @PostMapping(value = "/add",consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Product product){
        return ResponseEntity.status(CREATED).body(productService.saveProduct(product));
    }
    @GetMapping(value = "/short_description/{description}/{page_number}",produces = "application/json")
    public ResponseEntity<?> findUsingShortDescription(@PathVariable(value = "description") String description,@PathVariable(value = "page_number") String pageNumber){
        return ResponseEntity.status(OK).body(productService.findProductByShortDescription(description,Integer.parseInt(pageNumber)-1));
    }
    @GetMapping(value = "/detail_description/{description}/{page_number}",produces = "application/json")
    public ResponseEntity<?> findByDetailedDescription(@PathVariable(value = "description") String description,@PathVariable(value = "page_number")String pageNumber){
        return ResponseEntity.status(OK).body(productService.findProductByDetailDescription(description,Integer.parseInt(pageNumber)-1));
    }
    @GetMapping(value = "/category/{category}/{page_number}",produces = "application/json")
    public ResponseEntity<?> findUsingProductCategory(@PathVariable(value = "category")String category,@PathVariable(value = "page_number")String pageNumber){
        return ResponseEntity.status(OK).body(productService.findProductByCategory(category,Integer.parseInt(pageNumber)-1));
    }
    @GetMapping(value = "/price/start/{starting}/{page_number}",produces = "application/json")
    public ResponseEntity<?> findUsingStartingPrice(@PathVariable(value = "starting")String starting,@PathVariable(value = "page_number")String pageNumber){
        return ResponseEntity.status(OK).body(productService.findProductByStartingPrice(Double.parseDouble(starting),Integer.parseInt(pageNumber)-1));
    }
    @GetMapping(value = "/price/end/{ending}/{page_number}",produces = "application/json")
    public ResponseEntity<?> findByEndingPrice(@PathVariable(value = "ending")String ending,@PathVariable(value = "page_number")String pageNumber){
        return ResponseEntity.status(OK).body(productService.findProductByEndingPrice(Double.parseDouble(ending),Integer.parseInt(pageNumber)-1));
    }
    @GetMapping(value = "/end_bid_date/{end_date}/{page_number}",produces = "application/json")
    public ResponseEntity<?> findUsingBidEndDate(@PathVariable(value = "end_date")String endDate,@PathVariable(value = "page_number")String pageNumber){
        return ResponseEntity.status(OK).body(productService.findProductByBidEndDate(new Date(Long.parseLong(endDate)),Integer.parseInt(pageNumber)-1));
    }
    @PutMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> update(@RequestBody Product product){
        return ResponseEntity.status(ACCEPTED).body(productService.updateProduct(product));
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id")String id){
        productService.deleteProductById(Long.parseLong(id));
        return ResponseEntity.status(OK).body("Product deleted successfully....");
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteById(@RequestBody Product product){
        productService.deleteProduct(product);
        return ResponseEntity.status(OK).body("Product deleted successfully....");
    }
    @GetMapping("/category/{page}")
    public ResponseEntity<?> getAllCat(@PathVariable(value = "page")String page){
        return ResponseEntity.status(OK).body(categoryService.findAll(Integer.parseInt(page)-1));
    }
}
