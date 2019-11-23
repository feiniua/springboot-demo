package com.example.springboot.core.service.ProductServiceImpl;

import com.example.springboot.core.model.Product;
import com.example.springboot.core.model.Store;
import com.example.springboot.core.repository.ProductRepository;
import com.example.springboot.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:27
 * @description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findById(Integer id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public void save(String name, BigDecimal price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);
    }

    @Override
    public void updata(Integer id, String name, BigDecimal price) {
        Product product = productRepository.findById(id).get();
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Override
    public List<Product> findByName(String string) {
        return productRepository.findByName(string);
    }

}
