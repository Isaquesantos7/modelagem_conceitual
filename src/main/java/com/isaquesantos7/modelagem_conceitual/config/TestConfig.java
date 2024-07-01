package com.isaquesantos7.modelagem_conceitual.config;

import com.isaquesantos7.modelagem_conceitual.model.Category;
import com.isaquesantos7.modelagem_conceitual.repositories.CategoryRepository;
import com.isaquesantos7.modelagem_conceitual.resources.CategoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat0 = new Category(null, "Informática");
        Category cat1 = new Category(null, "Escritório");

        this.categoryRepository.saveAll(Arrays.asList(cat0, cat1));
    }

}
