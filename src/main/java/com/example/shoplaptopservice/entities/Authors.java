package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true)
    private Admins admins;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employees employees;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Admins getAdmins() {
        return admins;
    }

    public void setAdmins(Admins admins) {
        this.admins = admins;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
