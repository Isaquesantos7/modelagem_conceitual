package com.isaquesantos7.modelagem_conceitual.repositories;

import com.isaquesantos7.modelagem_conceitual.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
