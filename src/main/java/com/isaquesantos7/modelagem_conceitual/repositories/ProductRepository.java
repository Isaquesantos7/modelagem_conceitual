package com.isaquesantos7.modelagem_conceitual.repositories;

import com.isaquesantos7.modelagem_conceitual.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
