package com.example.springboot.core.repository;

import com.example.springboot.core.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 17:36
 * @description:
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * 通过姓与名查找
     * @param string
     * @param string1
     * @return
     */
    List<Employee> findByLastNameAndFirstName(String string, String string1);


}
