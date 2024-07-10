package com.isaquesantos7.modelagem_conceitual.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isaquesantos7.modelagem_conceitual.model.enums.PaymentState;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Order order;

    private Integer paymentState;

    public Payment() {}

    public Payment(Integer id, PaymentState paymentState, Order order) {
        this.id = id;
        this.paymentState = paymentState.getCode();
        this.order = order;
    }

    public Integer getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState.getCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentState=" + paymentState +
                '}';
    }
}
