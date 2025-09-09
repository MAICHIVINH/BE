package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Employees;
import com.example.shoplaptopservice.repositories.EmployeeRepository;
import com.example.shoplaptopservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employees> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employees> getEmployeePaging(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Optional<Employees> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employees createEmployee(Employees employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employees updateEmployee(Integer id, Employees employee){
        Employees existing = employeeRepository.findById(id).orElseThrow();
        // cập nhật từng field
        existing.setEmployeeName(employee.getEmployeeName());
        existing.setEmployeeGender(employee.getEmployeeGender());
        existing.setEmployeeEmail(employee.getEmployeeEmail());
        existing.setEmployeePassword(employee.getEmployeePassword());
        existing.setEmployeeResetToken(employee.getEmployeeResetToken());
        existing.setEmployeeTokenExpiration(employee.getEmployeeTokenExpiration());
        existing.setEmployeePhone(employee.getEmployeePhone());
        existing.setEmployeeAddress(employee.getEmployeeAddress());
        existing.setEmployeeStatus(employee.getEmployeeStatus());
        existing.setRoles(employee.getRoles());
        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employees> searchEmployeeByEmployeeName(String keyword) {
        return employeeRepository.findByEmployeeNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Employees> getEmployeeByStatusTrue() {
        return employeeRepository.findByEmployeeStatusTrue();
    }
}
