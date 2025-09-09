package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_gender")
    private Boolean customerGender;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_password")
    private String customerPassword;

    @Column(name = "customer_reset_token")
    private String customerResetToken;

    @Column(name = "customer_token_expiration")
    private Long customerTokenExpiration;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_create_date", nullable = false, updatable = false)
    private LocalDateTime customerCreateDate = LocalDateTime.now();

    @Column(name = "customer_status")
    private Boolean customerStatus;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerResetToken() {
        return customerResetToken;
    }

    public void setCustomerResetToken(String customerResetToken) {
        this.customerResetToken = customerResetToken;
    }

    public Long getCustomerTokenExpiration() {
        return customerTokenExpiration;
    }

    public void setCustomerTokenExpiration(Long customerTokenExpiration) {
        this.customerTokenExpiration = customerTokenExpiration;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public LocalDateTime getCustomerCreateDate() {
        return customerCreateDate;
    }

    public void setCustomerCreateDate(LocalDateTime customerCreateDate) {
        this.customerCreateDate = customerCreateDate;
    }

    public Boolean getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Boolean customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public  void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
