package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "userVouchers")
public class UserVouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_voucher_id")
    private Integer userVoucherId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "voucher_id", nullable = false)
    private Vouchers vouchers;

    @Column(name = "is_customer")
    private Boolean isCustomer;

    public Integer getUserVoucherId() {
        return userVoucherId;
    }

    public void setUserVoucherId(Integer userVoucherId) {
        this.userVoucherId = userVoucherId;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Vouchers getVouchers() {
        return vouchers;
    }

    public void setVouchers(Vouchers vouchers) {
        this.vouchers = vouchers;
    }

    public Boolean getCustomer() {
        return isCustomer;
    }

    public void setCustomer(Boolean customer) {
        isCustomer = customer;
    }
}
