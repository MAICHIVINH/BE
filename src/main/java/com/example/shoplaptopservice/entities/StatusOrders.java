package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "statusOrders")
public class StatusOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_order_id")
    private Integer statusOrderId;

    @Column(name = "status_order_name")
    private String statusOrderName;

    public Integer getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(Integer statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public String getStatusOrderName() {
        return statusOrderName;
    }

    public void setStatusOrderName(String statusOrderName) {
        this.statusOrderName = statusOrderName;
    }
}
