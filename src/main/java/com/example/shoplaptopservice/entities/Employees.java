package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_password")
    private String employeePassword;

    @Column(name = "employee_reset_token")
    private String employeeResetToken;

    @Column(name = "employee_token_expiration")
    private Long employeeTokenExpiration;

    @Column(name = "employee_phone")
    private String employeePhone;

    @Column(name = "employee_address")
    private String employeeAddress;

    @Column(name = "employee_gender")
    private Boolean employeeGender;

    @Column(name = "employee_status")
    private Boolean employeeStatus;

    @Column(name = "employee_create_date",nullable = false, updatable = false)
    private LocalDateTime employeeCreateDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public LocalDateTime getEmployeeCreateDate() {
        return employeeCreateDate;
    }

    public void setEmployeeCreateDate(LocalDateTime employeeCreateDate) {
        this.employeeCreateDate = employeeCreateDate;
    }

    public Boolean getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Boolean getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(Boolean employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Long getEmployeeTokenExpiration() {
        return employeeTokenExpiration;
    }

    public void setEmployeeTokenExpiration(Long employeeTokenExpiration) {
        this.employeeTokenExpiration = employeeTokenExpiration;
    }

    public String getEmployeeResetToken() {
        return employeeResetToken;
    }

    public void setEmployeeResetToken(String employeeResetToken) {
        this.employeeResetToken = employeeResetToken;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
