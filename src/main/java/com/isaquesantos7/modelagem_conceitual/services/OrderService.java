package com.isaquesantos7.modelagem_conceitual.services;

import com.isaquesantos7.modelagem_conceitual.model.Order;
import com.isaquesantos7.modelagem_conceitual.repositories.OrderRepository;
import com.isaquesantos7.modelagem_conceitual.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order find(Integer id) {

        return this.orderRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Order> listAll() {

        return this.orderRepository.findAll();
    }

}
