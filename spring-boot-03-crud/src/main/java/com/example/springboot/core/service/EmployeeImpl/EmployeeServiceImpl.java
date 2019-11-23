package com.example.springboot.core.service.EmployeeImpl;

import com.example.springboot.core.model.Employee;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.repository.EmployeeRepository;
import com.example.springboot.core.service.EmployeeService;
import com.example.springboot.core.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author: huu
 * @date: 2019/10/17 17:52
 * @description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    StoreService storeService;

    @Override
    public Employee findById(Integer id) {
        try {
            Employee employee = employeeRepository.findById(id).get();
            return employee;
        } catch (NoSuchElementException e) {
            Employee employee = new Employee();
            employee.setId(0);
            return employee;
        }
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        Employee save = employeeRepository.save(employee);
        return save;
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByLastNameAndFirstName(String string, String string1) {
        return employeeRepository.findByLastNameAndFirstName(string,string1);
    }

    @Override
    public Employee saveNewEmployee(Employee employee, String storeName) {
        employeeRepository.save(employee);
        List<Store> list = storeService.findByName(storeName);
        Store store = list.get(0);
        employee.setStore(store);
        employeeRepository.save(employee);
        return employee;
    }
}
