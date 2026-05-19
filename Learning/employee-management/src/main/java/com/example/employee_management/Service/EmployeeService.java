package com.example.employee_management.Service;

import com.example.employee_management.Entity.Employee;
import com.example.employee_management.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // save method
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    //Get All methods
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    // Get Employee by ID
    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id).orElse(null);
    }
    // Delete Employee
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
}
