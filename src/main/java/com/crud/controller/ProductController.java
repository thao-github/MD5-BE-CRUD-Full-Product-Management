package com.crud.controller;

import com.crud.model.Product;
import com.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> getProductList() {
        return productService.findAll();
    }

    @PostMapping("/add")
    public void createProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PutMapping("/edit/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
