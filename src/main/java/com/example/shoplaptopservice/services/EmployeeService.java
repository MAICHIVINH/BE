package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employees> getAllEmployee();

    Page<Employees> getEmployeePaging(Pageable pageable);

    Optional<Employees> getEmployeeById(Integer id);

    Employees createEmployee(Employees employee);

    Employees updateEmployee(Integer id, Employees employee);

    void deleteEmployee(Integer id);

    List<Employees> searchEmployeeByEmployeeName(String keyword);

    List<Employees> getEmployeeByStatusTrue();
}
