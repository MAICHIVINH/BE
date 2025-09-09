package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vouchers")
public class Vouchers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    private Integer voucherId;

    @Column(name = "voucher_code", nullable = false, unique = true, length = 50)
    private String voucherCode;

    @Column(name = "voucher_description")
    private String voucherDescription;

    @Column(name = "voucher_percent_decrease")
    private Integer voucherPercentDecrease;

    @Temporal(TemporalType.DATE)
    @Column(name = "voucher_expiry")
    private Date voucherExpiry;

    @Column(name = "voucher_quantity_left")
    private Integer voucherQuantityLeft;

    @Column(name = "voucher_conditions_apply", nullable = false)
    private BigDecimal voucherConditionsApply;

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherDescription() {
        return voucherDescription;
    }

    public void setVoucherDescription(String voucherDescription) {
        this.voucherDescription = voucherDescription;
    }

    public Integer getVoucherPercentDecrease() {
        return voucherPercentDecrease;
    }

    public void setVoucherPercentDecrease(Integer voucherPercentDecrease) {
        this.voucherPercentDecrease = voucherPercentDecrease;
    }

    public Date getVoucherExpiry() {
        return voucherExpiry;
    }

    public void setVoucherExpiry(Date voucherExpiry) {
        this.voucherExpiry = voucherExpiry;
    }

    public Integer getVoucherQuantityLeft() {
        return voucherQuantityLeft;
    }

    public void setVoucherQuantityLeft(Integer voucherQuantityLeft) {
        this.voucherQuantityLeft = voucherQuantityLeft;
    }

    public BigDecimal getVoucherConditionsApply() {
        return voucherConditionsApply;
    }

    public void setVoucherConditionsApply(BigDecimal voucherConditionsApply) {
        this.voucherConditionsApply = voucherConditionsApply;
    }
}
