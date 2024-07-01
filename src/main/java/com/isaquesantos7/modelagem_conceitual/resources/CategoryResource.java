package com.isaquesantos7.modelagem_conceitual.resources;

import com.isaquesantos7.modelagem_conceitual.model.Category;
import com.isaquesantos7.modelagem_conceitual.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categorias/{id}")
    public ResponseEntity<Category> findById(@PathVariable(value = "id") Integer id) {
        Category cat = this.categoryService.find(id);

        return ResponseEntity.status(HttpStatus.OK).body(cat);
    }
}
