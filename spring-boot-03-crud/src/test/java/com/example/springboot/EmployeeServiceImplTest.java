package com.example.springboot;

import com.example.springboot.core.model.Employee;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.service.EmployeeService;
import com.example.springboot.core.service.StoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: huu
 * @date: 2019/11/12 19:58
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    StoreService storeService;

    @Test
    @Transactional
    public void findById() {
        // 新建employee
        Employee employee = new Employee();
        employee.setLastName("张");
        employee.setFirstName("敏");
        Store store = storeService.findByName("商店").get(0);
        employee.setStore(store);
        employeeService.save(employee);

        // 调用findById
        Employee employee1 = employeeService.findById(employee.getId());
        assertEquals("张",employee1.getLastName());
        assertEquals("敏",employee1.getFirstName());
        assertEquals("商店",employee1.getStore().getName());

        // 当没有id时返回一个id为零的employee
        Employee employee2 = employeeService.findById(9999);
        assertEquals(new Integer(0),employee2.getId());
    }

    @Test
    @Transactional
    public void findAll() {
        // 新建两个employee
        Employee employee = new Employee();
        Employee employee1 = new Employee();
        employee.setLastName("张");
        employee.setFirstName("敏");
        employee1.setLastName("李");
        employee1.setFirstName("兴");
        employeeService.save(employee);
        employeeService.save(employee1);

        // 调用findAll
        List<Employee> list = employeeService.findAll();
        // 检查list中是否有新建的两个employee
        int flag = 0;
        for(int i = 0; i < list.size(); i++) {
            Employee employee2 = list.get(i);
            if(employee2.getLastName() == "张" && employee2.getFirstName() == "敏") {
                flag++;
            } else if(employee2.getLastName() == "李" && employee2.getFirstName() == "兴") {
                flag++;
            }
        }
        assertEquals(2,flag);

    }

    @Test
    @Transactional
    public void save() {
        // 未保存前查询为空
        List<Employee> list = employeeService.findByLastNameAndFirstName("张", "敏");
        assertEquals(0, list.size());

        // 调用save
        Employee employee = new Employee();
        employee.setLastName("张");
        employee.setFirstName("敏");;
        employeeService.save(employee);

        // 调用后查询有值
        Employee employee2 = employeeService.findByLastNameAndFirstName("张", "敏").get(0);
        assertEquals(true,employee2 != null);
    }

    @Test
    @Transactional
    public void delete() {
        // 新建employee
        Employee employee = new Employee();
        employee.setLastName("张");
        employee.setFirstName("敏");
        employeeService.save(employee);

        // 调用前查询有值
        Employee employee1 = employeeService.findByLastNameAndFirstName("张", "敏").get(0);
        assertEquals(true, employee1 != null);

        // 调用delete
        employeeService.delete(employee.getId());

        // 调用后查询为空
        List<Employee> list  = employeeService.findByLastNameAndFirstName("张", "敏");
        assertEquals(0,list.size());
    }

    @Test
    @Transactional
    public void findByLastNameAndFirstName() {
        // 新建employee
        Employee employee = new Employee();
        employee.setLastName("张");
        employee.setFirstName("敏");
        employeeService.save(employee);

        // 调用findByLastNameAndFirstName
        // 并将返回的对象进行断言判断
        Employee employee1 = employeeService.findByLastNameAndFirstName("张", "敏").get(0);
        assertEquals("张", employee1.getLastName());
        assertEquals("敏", employee1.getFirstName());
    }

    @Test
    @Transactional
    public void saveNewEmployee() {
        // 新建employee 并获取一个已有的store
        Employee employee = new Employee();
        Store store = storeService.findByName("商店").get(0);
        employee.setLastName("张");
        employee.setFirstName("敏");

        // 调用saveNewEmployee
        employeeService.saveNewEmployee(employee, "商店");

        // 查询到employee后判断employee的信息
        Employee employee1 = employeeService.findById(employee.getId());
        assertEquals("张", employee1.getLastName());
        assertEquals("敏", employee1.getFirstName());
        assertEquals("商店", employee1.getStore().getName());
        assertEquals(true, employee1.getStore() == store);

    }
}