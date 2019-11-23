package com.example.springboot.api;

import com.example.springboot.core.model.Employee;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.service.EmployeeImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 17:37
 * @description:
 */
@RestController
public class EmployeeApi {

    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public List<Employee> findEmployees(){
        List<Employee> list = employeeService.findAll();
        return list;
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployee(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        return employee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(String lastName,String firstName,String storeName){
        Employee employee = new Employee();
        employee.setLastName(lastName);
        employee.setFirstName(firstName);
        return employeeService.saveNewEmployee(employee,storeName);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        employeeService.delete(id);
    }

    @PutMapping("/employee/{id}")
    public void updataEmployee(@PathVariable Integer id,String lastName,String firstName,String storeName) {
        Employee employee = employeeService.findById(id);
        employee.setLastName(lastName);
        employee.setFirstName(firstName);
        employeeService.saveNewEmployee(employee,storeName);
    }

}
