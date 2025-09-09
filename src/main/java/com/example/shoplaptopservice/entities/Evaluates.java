package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evaluates")
public class Evaluates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluate_id")
    private Integer evaluateId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products products;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    @Column(name = "evaluate_stars_number")
    private Integer evaluateStarsNumber;

    @Column(name = "evaluate_content")
    private String evaluateContent;

    @Column(name = "evaluation_date", nullable = false, updatable = false)
    private LocalDateTime evaluationDate = LocalDateTime.now();

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Integer getEvaluateStarsNumber() {
        return evaluateStarsNumber;
    }

    public void setEvaluateStarsNumber(Integer evaluateStarsNumber) {
        this.evaluateStarsNumber = evaluateStarsNumber;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public LocalDateTime getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDateTime evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
