package com.isaquesantos7.modelagem_conceitual.model;

import com.isaquesantos7.modelagem_conceitual.model.enums.PaymentState;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento_com_cartao")
public class PaymentWithCard extends Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer numberPlots;

    public PaymentWithCard() {}

    public PaymentWithCard(Integer id, PaymentState paymentState, Order order, Integer numberPlots) {
        super(id, paymentState, order);
        this.numberPlots = numberPlots;
    }

    public Integer getNumberPlots() {
        return numberPlots;
    }

    public void setNumberPlots(Integer numberPlots) {
        this.numberPlots = numberPlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PaymentWithCard that = (PaymentWithCard) o;
        return Objects.equals(numberPlots, that.numberPlots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberPlots);
    }

    @Override
    public String toString() {
        return "PaymentWithCard{" +
                "numberPlots=" + numberPlots +
                '}';
    }
}
