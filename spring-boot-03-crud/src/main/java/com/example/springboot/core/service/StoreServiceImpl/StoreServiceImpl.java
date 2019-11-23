package com.example.springboot.core.service.StoreServiceImpl;

import com.example.springboot.core.model.Product;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.repository.ProductRepository;
import com.example.springboot.core.repository.StoreRepository;
import com.example.springboot.core.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:12
 * @description:
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Store findById(Integer id) {
        Store store = storeRepository.findById1(id);
        return store;
    }

    @Override
    public void save(String name, Integer[] productsId) {
        Store store = new Store();
        List<Product> listProduct = new ArrayList<Product>();
        store.setName(name);
        if(productsId != null) {
            for(int i = 0; i < productsId.length; i++) {
                Integer id = productsId[i];
                Product product = productRepository.findById(id).get();
                listProduct.add(product);
            }
        }
        store.setListProduct(listProduct);
        Store save = storeRepository.save(store);
    }

    @Override
    public void save(Integer id, String name, Integer[] productsId) {
        Store store = storeRepository.findById1(id);
        List<Product> listProduct = new ArrayList<Product>();
        store.setName(name);
        if(productsId != null) {
            for(int i = 0; i < productsId.length; i++) {
                Integer id1 = productsId[i];
                Product product = productRepository.findById(id1).get();
                listProduct.add(product);
            }
        }
        store.setListProduct(listProduct);
        storeRepository.save(store);
    }

    @Override
    public void delete(Store store) {
        storeRepository.delete(store);
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public List<Store> findByName(String string) {
        return storeRepository.findByName(string);
    }
}
