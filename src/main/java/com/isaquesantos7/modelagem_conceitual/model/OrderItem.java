package com.isaquesantos7.modelagem_conceitual.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_item_pedido")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public OrderItem() {}

    public OrderItem(Order order, Product product, Double discount, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public Product getProduct() {
        return id.getProduct();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
