package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Customers;
import com.example.shoplaptopservice.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    List<Employees> findByEmployeeNameContainingIgnoreCase(String keyword);
    List<Employees> findByEmployeeStatusTrue();
}
