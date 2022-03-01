package com.crud.controller;

import com.crud.model.Category;
import com.crud.model.Product;
import com.crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<Category> getCategoryList() {
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public void createCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Optional<Category> findCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/edit/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.save(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
