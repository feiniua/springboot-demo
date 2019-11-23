package com.example.springboot.api;

import com.example.springboot.core.model.Product;
import com.example.springboot.core.service.ProductService;
import com.example.springboot.core.service.ProductServiceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:29
 * @description:
 */
@RestController
public class ProductApi {

    @Autowired
    ProductServiceImpl productService;


    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findProduct(@PathVariable("id") Integer id){
        Product store = productService.findById(id);
        return store;
    }

    @PostMapping("/product")
    public void addProduct(String name, BigDecimal price) {
        productService.save(name,price);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PutMapping("/product/{id}")
    public void editProduct(@PathVariable Integer id, String name, BigDecimal price) {
        productService.updata(id,name,price);
    }
}
