package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "systemLog")
public class SystemLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_log_id")
    private Integer systemLogId;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true)
    private Admins admins;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employees employees;

    @Column(name = "action_description")
    private String actionDescription;

    @Column(name = "log_time", nullable = false, updatable = false)
    private LocalDateTime logTime = LocalDateTime.now();

    public Integer getSystemLogId() {
        return systemLogId;
    }

    public void setSystemLogId(Integer systemLogId) {
        this.systemLogId = systemLogId;
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

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }
}
