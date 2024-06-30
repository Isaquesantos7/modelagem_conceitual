package com.isaquesantos7.modelagem_conceitual.resources;

import com.isaquesantos7.modelagem_conceitual.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryResource {

    @GetMapping("/api/categorias")
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        list.add(new Category(1, "Informatica"));
        list.add(new Category(2, "Eletrodómesticos"));

        return list;
    }
}
