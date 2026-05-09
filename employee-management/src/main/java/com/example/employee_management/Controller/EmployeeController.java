package com.example.employee_management.Controller;

import com.example.employee_management.Entity.Employee;
import com.example.employee_management.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
    private EmployeeService employeeService;
  // create a new employees
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    // get employee details
    @GetMapping
public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
}
    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    // deleting employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
    }
    // updating details
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee existingEmployee=employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());
        return employeeService.saveEmployee(existingEmployee);
    }
    // partial update
    @PatchMapping("/{id}")
    public Employee updateEmployeePartial(@PathVariable Long id, @RequestBody Employee employee){
        Employee existingEmployee=employeeService.getEmployeeById(id);
        if(employee.getFirstName()!=null){
            existingEmployee.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName()!=null){
            existingEmployee.setLastName(employee.getLastName());
        }
        if(employee.getDepartment()!=null){
            existingEmployee.setDepartment(employee.getDepartment());
        }
        if(employee.getSalary()!=0 ){
            existingEmployee.setSalary(employee.getSalary());
        }
        return employeeService.saveEmployee(existingEmployee);
    }
}
