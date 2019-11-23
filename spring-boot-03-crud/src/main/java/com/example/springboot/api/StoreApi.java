package com.example.springboot.api;

import com.example.springboot.core.model.Product;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.service.ProductService;
import com.example.springboot.core.service.StoreServiceImpl.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:16
 * @description:
 */
@RestController
public class StoreApi {

    @Autowired
    StoreServiceImpl storeService;


    @GetMapping("/stores")
    public List<Store> saveStore(Store store){
        return storeService.findAll();
    }

    @GetMapping("/store/{id}")
    public Store findStore(@PathVariable("id") Integer id){
        Store store = storeService.findById(id);
        return store;
    }

    @PostMapping("/store")
    public void addStore(String name, Integer[] productsId) {
        storeService.save(name, productsId);
    }

    @DeleteMapping("/store/{id}")
    public void deleteStore(@PathVariable Integer id) {
        Store store = storeService.findById(id);
        storeService.delete(store);
    }

    @PutMapping("/store/{id}")
    public void editStore(@PathVariable Integer id, String name, Integer[] productsId) {
        storeService.save(id,name,productsId);
    }
}
