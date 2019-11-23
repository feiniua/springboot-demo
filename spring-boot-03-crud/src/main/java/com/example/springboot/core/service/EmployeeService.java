package com.example.springboot.core.service;

import com.example.springboot.core.model.Employee;
import com.example.springboot.core.model.Store;

import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 17:49
 * @description:
 */
public interface EmployeeService {

    /**
     * 根据id查询雇员信息
     * @param id
     * @return Employee
     */
    Employee findById(Integer id);

    /**
     * 查询所有雇员信息
     * @return List<Employee>
     */
    List<Employee> findAll();

    /**
     * 保存或更新信息
     * @param employee
     * @return
     */
    Employee save(Employee employee);

    /**
     * 删除雇员
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据姓名查询雇员
     * @param string
     * @param string1
     * @return
     */
    List<Employee> findByLastNameAndFirstName(String string, String string1);

    /**
     * 添加雇员时
     * @param employee
     * @param storeName
     * @return
     */
    Employee saveNewEmployee(Employee employee, String storeName);

}
