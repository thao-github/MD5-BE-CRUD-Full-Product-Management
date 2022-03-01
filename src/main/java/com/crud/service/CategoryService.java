package com.crud.service;

import com.crud.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void delete(Long id);
}
