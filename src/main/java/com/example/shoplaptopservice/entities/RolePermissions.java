package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rolePermissions")
public class RolePermissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_permission_id")
    private Integer rolePermissionId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permissions permissions;

    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }
}
