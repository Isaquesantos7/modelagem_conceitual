package com.isaquesantos7.modelagem_conceitual.resources;

import com.isaquesantos7.modelagem_conceitual.model.Order;
import com.isaquesantos7.modelagem_conceitual.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping("/api/pedidos/{id}")
    public ResponseEntity<Order> findById(@PathVariable(value = "id") Integer id) {
        Order order = this.orderService.find(id);

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @GetMapping("/api/pedidos")
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = this.orderService.listAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
