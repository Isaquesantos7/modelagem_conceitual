package com.isaquesantos7.modelagem_conceitual.services;

import com.isaquesantos7.modelagem_conceitual.model.Category;
import com.isaquesantos7.modelagem_conceitual.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category find(Integer id) {

        return this.categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll() {

        return this.categoryRepository.findAll();
    }
}
