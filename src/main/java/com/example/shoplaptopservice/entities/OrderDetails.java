package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products products;

    @Column(name = "order_detail_quantity")
    private Integer orderDetailQuantity;

    @Column(name = "order_detail_total")
    private BigDecimal orderDetailTotal;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Integer getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    public void setOrderDetailQuantity(Integer orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }

    public BigDecimal getOrderDetailTotal() {
        return orderDetailTotal;
    }

    public void setOrderDetailTotal(BigDecimal orderDetailTotal) {
        this.orderDetailTotal = orderDetailTotal;
    }
}
