package com.example.springboot.core.repository;

import com.example.springboot.core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author: huu
 * @date: 2019/10/17 18:25
 * @description:
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**
     * 通过商店名查找
     * @param string
     * @return
     */
    List<Product> findByName(String string);

}
