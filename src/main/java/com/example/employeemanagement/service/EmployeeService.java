package com.example.employeemanagement.service;

import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        if(employee.getId() == null || !repository.findById(employee.getId()).isPresent())
            throw new EmployeeNotFoundException("Employee not found with ID: "+employee.getId());
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if(!repository.findById(id).isPresent())
            throw new EmployeeNotFoundException("Employee not found with ID: "+id);
        repository.deleteById(id);
    }
}
