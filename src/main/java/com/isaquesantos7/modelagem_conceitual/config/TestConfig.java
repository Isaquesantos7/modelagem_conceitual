package com.isaquesantos7.modelagem_conceitual.config;

import com.isaquesantos7.modelagem_conceitual.model.Category;
import com.isaquesantos7.modelagem_conceitual.model.City;
import com.isaquesantos7.modelagem_conceitual.model.Product;
import com.isaquesantos7.modelagem_conceitual.model.State;
import com.isaquesantos7.modelagem_conceitual.repositories.CategoryRepository;
import com.isaquesantos7.modelagem_conceitual.repositories.CityRepository;
import com.isaquesantos7.modelagem_conceitual.repositories.ProductRepository;
import com.isaquesantos7.modelagem_conceitual.repositories.StateRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Informática");
        Category cat2 = new Category(null, "Escritório");

        Product p1 = new Product(null, "Manga", 6.77);
        Product p2 = new Product(null, "Manteiga", 8.99);
        Product p3 = new Product(null, "Computador", 2000.00);

        State st1 = new State(null, "Minas Gerais");
        State st2 = new State(null, "São Paulo");

        City c1 = new City(null, "Uberlandia", st1);
        City c2 = new City(null, "São Paulo", st2);
        City c3 = new City(null, "Campinas", st2);

        st1.getCities().add(c1);
        st2.getCities().addAll(Arrays.asList(c2, c3));

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().add(p2);

        p1.getCategories().add(cat2);
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().add(cat2);

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        this.productRepository.saveAll(Arrays.asList(p1, p2, p3));
        this.stateRepository.saveAll(Arrays.asList(st1, st2));
        this.cityRepository.saveAll(Arrays.asList(c1, c2, c3));

    }

}
