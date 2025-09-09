package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Employees;
import com.example.shoplaptopservice.services.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employees> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/page")
    public Page<Employees> getEmployeePaging(@RequestParam int page, @RequestParam int size) {
        return employeeService.getEmployeePaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Employees> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public String createEmployee(@RequestBody Employees employee) {
        employeeService.createEmployee(employee);
        return "Employee created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Integer id, @RequestBody Employees employee) {
        employeeService.updateEmployee(id, employee);
        return "Employee updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }

    @GetMapping("/search")
    public List<Employees> searchEmployeeByEmployeeName(@RequestParam String keyword) {
        return employeeService.searchEmployeeByEmployeeName(keyword);
    }

    @GetMapping("/active")
    public List<Employees> getEmployeeByStatusTrue() {
        return employeeService.getEmployeeByStatusTrue();
    }
}
