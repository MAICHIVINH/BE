package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Customers;
import com.example.shoplaptopservice.services.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customers> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/page")
    public Page<Customers> getCustomerPaging(@RequestParam int page, @RequestParam int size) {
        return customerService.getCustomerPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Customers> getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/add")
    public String createCustomer(@RequestBody Customers customer) {
        customerService.createCustomer(customer);
        return "Customer created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateCustomer(@PathVariable Integer id, @RequestBody Customers customer) {
        customerService.updateCustomer(id, customer);
        return "Customer updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully!";
    }

    @GetMapping("/search")
    public List<Customers> searchCustomer(@RequestParam String keyword) {
        return customerService.searchCustomerByCustomerName(keyword);
    }

    @GetMapping("/active")
    public List<Customers> getActiveCustomer() {
        return customerService.getCustomerByStatusTrue();
    }
}
