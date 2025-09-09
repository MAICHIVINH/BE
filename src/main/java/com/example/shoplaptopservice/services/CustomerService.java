package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customers> getAllCustomer();

    Page<Customers> getCustomerPaging(Pageable pageable);

    Optional<Customers> getCustomerById(Integer id);

    Customers createCustomer(Customers customer);

    Customers updateCustomer(Integer id, Customers customer);

    void deleteCustomer(Integer id);

    List<Customers> searchCustomerByCustomerName(String keyword);

    List<Customers> getCustomerByStatusTrue();
}
