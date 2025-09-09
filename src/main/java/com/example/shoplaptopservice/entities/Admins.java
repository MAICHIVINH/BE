package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "admin_user_name")
    private String adminUserName;

    @Column(name = "admin_password")
    private String adminPassword;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "admin_number_phone")
    private String adminNumberPhone;

    public String getAdminAvatar() {
        return adminAvatar;
    }

    public void setAdminAvatar(String adminAvatar) {
        this.adminAvatar = adminAvatar;
    }

    @Column(name="admin_avatar")
    private String adminAvatar;

    @Column(name = "admin_address")
    private String adminAddress;

    @Column(name = "admin_status")
    private Boolean adminStatus;

    @Column(name = "admin_reset_token")
    private String adminResetToken;

    @Column(name = "admin_token_expiration")
    private Long adminTokenExpiration;

    @Column(name = "admin_create_date", nullable = false, updatable = false)
    private LocalDateTime adminCreateDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminNumberPhone() {
        return adminNumberPhone;
    }

    public void setAdminNumberPhone(String adminNumberPhone) {
        this.adminNumberPhone = adminNumberPhone;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public Boolean getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Boolean adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getAdminResetToken() {
        return adminResetToken;
    }

    public void setAdminResetToken(String adminResetToken) {
        this.adminResetToken = adminResetToken;
    }

    public Long getAdminTokenExpiration() {
        return adminTokenExpiration;
    }

    public void setAdminTokenExpiration(Long adminTokenExpiration) {
        this.adminTokenExpiration = adminTokenExpiration;
    }

    public LocalDateTime getAdminCreateDate() {
        return adminCreateDate;
    }

    public void setAdminCreateDate(LocalDateTime adminCreateDate) {
        this.adminCreateDate = adminCreateDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
