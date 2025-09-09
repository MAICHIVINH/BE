package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Customers;
import com.example.shoplaptopservice.repositories.CustomerRepository;
import com.example.shoplaptopservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customers> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public Page<Customers> getCustomerPaging(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customers> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customers createCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customers updateCustomer(Integer id, Customers customer) {
        Customers existing = customerRepository.findById(id).orElseThrow();
        // cập nhật từng field
        existing.setCustomerName(customer.getCustomerName());
        existing.setCustomerGender(customer.getCustomerGender());
        existing.setCustomerEmail(customer.getCustomerEmail());
        existing.setCustomerPassword(customer.getCustomerPassword());
        existing.setCustomerResetToken(customer.getCustomerResetToken());
        existing.setCustomerTokenExpiration(customer.getCustomerTokenExpiration());
        existing.setCustomerPhone(customer.getCustomerPhone());
        existing.setCustomerAddress(customer.getCustomerAddress());
        existing.setCustomerStatus(customer.getCustomerStatus());
        existing.setIsDeleted(customer.getIsDeleted());
        return customerRepository.save(existing);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customers> searchCustomerByCustomerName(String keyword) {
        return customerRepository.findByCustomerNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Customers> getCustomerByStatusTrue() {
        return customerRepository.findByCustomerStatusTrue();
    }
}
