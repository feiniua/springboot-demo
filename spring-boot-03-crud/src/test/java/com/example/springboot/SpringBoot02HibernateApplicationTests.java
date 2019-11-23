package com.example.springboot;

import com.example.springboot.core.model.Employee;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.repository.EmployeeRepository;
import com.example.springboot.core.repository.StoreRepository;
import com.example.springboot.core.service.EmployeeImpl.EmployeeServiceImpl;
import com.example.springboot.core.service.ProductService;
import com.example.springboot.core.service.StoreServiceImpl.StoreServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02HibernateApplicationTests {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProductService productService;

    @Autowired
    StoreServiceImpl storeService;

    @Autowired
    StoreRepository storeRepository;

    @Test
    public void contextLoads() {

    }

    @Test
    public void transactionTest(){
    }

    @Test
    public void addTest() {
//        Employee employee = new Employee();
//        employee.setLastName("李");
//        employee.setFirstName("致远");
//        List<Store> listStore = storeService.findByName("商店");
//        Store store = listStore.get(0);
//        employeeService.saveNewEmployee(employee,store);
//
//        List<Employee> listEmployee = employeeService.findByLastNameAndFirstName("李","致远");
//        Employee employee1 = listEmployee.get(0);
//        assertEquals("商店",employee1.getStore().getName());
//
//        Product product = productService.findById(4);
//        Product product1 = productService.findById(5);
//
//        List<Product> list = new ArrayList<Product>();
//        list.add(product);
//        list.add(product1);


    }

    @Test
    public void findTest(){
//        List<Employee> list = employeeService.findByLastNameAndFirstName("张", "小明");
//        Employee employee = list.get(0);
//        assertEquals(2,employee.getId());
//
//        List<Product> list1 = productService.findByName("面包");
//        Product product = list1.get(0);
//        assertEquals(2,product.getId());
//
//        List<Store> list2 = storeService.findByName("商店");
//        Store store = list2.get(0);
//        assertEquals(3,store.getId());



    }

//    @Test
//    public void productFindAllStoreTest() {
//        Product product = productService.findById(1);
//        List<Store> list = productService.findAllStore(product);
//        System.out.println(list);
//    }

    @Test
    public void findStoreTest(){
        System.out.println(storeService.findById(1));
    }

    /*
    *   瞬时态 没有id值
    *   持久态 与session有关联
    *   托管态 与session无关联
    *
    *   save时如果是瞬时态则添加
    *           持久态跟托管态则修改
    *
    *   有一片快照区在session后跟一级缓存区内容一样
    *   如果修改了一级缓存区的内容
    *   最后提交的时候会进行判断，如果不一样则提交，一样不提交
    * */
    @Test
    public void updataStoreTest(){

//        product1.
        List<Store> list = productService.findById(3).getListStore();

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }

    }

    @Test
    public void deleteStoreTest(){
        employeeService.delete(63);

    }

    @Test
//    @Transactional
    /*
    * 游离态不能*/
    public void saveEmployeeTest(){
        Employee employee = new Employee();
        Store store = new Store();
        store.setName("xiaohong");
        employee.setLastName("wang");
        employee.setFirstName("wu");
//        employeeService.save(employee);
//        employee.setStore(store);
        employeeService.save(employee);

//        设置了主键生成策略
//        Integer id1 = employee.getId();
//        Employee employee1 = employeeService.findById(id1);
//        assertEquals("zhang",employee1.getLastName());
//        assertEquals("san",employee1.getFirstName());
    }
}
