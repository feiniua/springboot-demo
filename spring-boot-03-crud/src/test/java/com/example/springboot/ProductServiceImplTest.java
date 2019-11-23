package com.example.springboot;

import com.example.springboot.core.model.Product;
import com.example.springboot.core.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: huu
 * @date: 2019/11/12 20:54
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    @Transactional
    public void findById() {
        productService.save("Coffee",new BigDecimal("35.5"));
        Product product = productService.findByName("Coffee").get(0);

        Product product1 = productService.findById(product.getId());
        assertEquals("Coffee", product1.getName());
        assertEquals(0,product1.getPrice().compareTo(new BigDecimal("35.5")));
    }

    @Test
    @Transactional
    public void save() {
        // 保存前判断
        List<Product> list = productService.findByName("Coffee");
        assertEquals(0,list.size());

        productService.save("Coffee", new BigDecimal("35.5"));
        Product product = productService.findByName("Coffee").get(0);

        // 保存后判断
        assertEquals("Coffee",product.getName());
        assertEquals(0,new BigDecimal(35.5).compareTo(product.getPrice()));
    }

    @Test
    @Transactional
    public void updata() {
        // 先保存一个product
        productService.save("Coffee", new BigDecimal("35.5"));
        Product product = productService.findByName("Coffee").get(0);

        // 调用updata
        productService.updata(product.getId(),"Coke",new BigDecimal(3.5));

        // 调用后用先id查询信息
        Product product1 = productService.findById(product.getId());
        assertEquals("Coke",product1.getName());
        assertEquals(0,new BigDecimal(3.5).compareTo(product1.getPrice()));
    }

    @Test
    @Transactional
    public void findAll() {
        // 新建2个product
        productService.save("Coffee", new BigDecimal(35.5));
        productService.save("Coke", new BigDecimal(3.5));

        // 调用findAll
        List<Product> list = productService.findAll();

        // 判断list中是否有新建的两个product
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            if(product.getName() == "Coffee" && product.getPrice().compareTo(new BigDecimal(35.5)) == 0) {
                flag++;
            } else if(product.getName() == "Coke" && product.getPrice().compareTo(new BigDecimal(3.5)) == 0){
                flag++;
            }
        }
        assertEquals(2,flag);
    }

    @Test
    @Transactional
    public void delete() {
        // 保存一个product
        productService.save("Coffee", new BigDecimal(35.5));

        // 调用delete前 查询有值
        Product product = productService.findByName("Coffee").get(0);
        assertEquals(0,new BigDecimal(35.5).compareTo(product.getPrice()));

        // 调用delete
        productService.delete(product.getId());

        // 调用delete后 查询为空
        List<Product> list = productService.findByName("Coffee");
        assertEquals(0,list.size());
    }

    @Test
    @Transactional
    public void findByName() {
        // 保存一个product
        productService.save("Coffee", new BigDecimal(35.5));

        // 调用findByName
        Product product = productService.findByName("Coffee").get(0);

        // 断言findByName返回的对象
        assertEquals("Coffee",product.getName());
        assertEquals(0,new BigDecimal(35.5).compareTo(product.getPrice()));

    }

}