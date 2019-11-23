package com.example.springboot;

import com.example.springboot.core.model.Product;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.service.StoreService;
import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolverException;
import org.hibernate.procedure.ProcedureOutputs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: huu
 * @date: 2019/11/13 12:06
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceImplTest {

    @Autowired
    StoreService storeService;

    @Test
    @Transactional
    public void findById() {
        Integer[] integer = {};
        // 保存一个对象
        storeService.save("Shop", integer);

        // 获取保存的对象
        Store store= storeService.findByName("Shop").get(0);

        //
        Store store1 = storeService.findById(store.getId());
        assertEquals("Shop", store1.getName());
        assertEquals(0, store1.getListProduct().size());
    }

    @Test
    @Transactional
    public void save() {
        // 按商店名跟所售的商品id保存
        Integer[] integer = {1,2,3};
        storeService.save("Shop",integer);

        // 按姓名查找到store
        Store store = storeService.findByName("Shop").get(0);
        assertEquals("Shop",store.getName());
        assertEquals(3,store.getListProduct().size());

    }

    @Test
    @Transactional
    public void testSave() {
        // 保存一个store
        Integer[] integers = {};
        storeService.save("Shop",integers);
        Store store = storeService.findByName("Shop").get(0);

        // 调用用于更新的save
        Integer[] integers1 = {1,2,3};
        storeService.save(store.getId(),"Store",integers1);
        Store store1 = storeService.findById(store.getId());

        assertEquals("Store",store1.getName());
        assertEquals(3,store1.getListProduct().size());
    }

    @Test
    @Transactional
    public void delete() {
        // 保存一个store
        Integer[] integers = {};
        storeService.save("Shop",integers);

        // 调用delete前
        assertEquals(1,storeService.findByName("Shop").size());
        assertEquals("Shop",storeService.findByName("Shop").get(0).getName());

        Store store = storeService.findByName("Shop").get(0);
        storeService.delete(store);

        // 调用delete后
        assertEquals(0,storeService.findByName("Shop").size());
    }

    @Test
    @Transactional
    public void findAll() {
        // 保存两个store
        Integer[] integers = {};
        storeService.save("Shop1",integers);
        storeService.save("Shop2",integers);

        List<Store> list = storeService.findAll();

        // 对list的值进行判断
        int flag = 0;
        for(int i = 0; i < list.size(); i++) {
            Store store = list.get(i);
            if(store.getName() == "Shop1" || store.getName() == "Shop2") {
                flag++;
            }
        }
        assertEquals(2,flag);
    }

    @Test
    @Transactional
    public void findByName() {
        // 保存一个store
        Integer[] integers = {};
        storeService.save("Shop",integers);

        Store store = storeService.findByName("Shop").get(0);

        assertEquals("Shop",store.getName());
        assertEquals(0,store.getListProduct().size());
    }
}