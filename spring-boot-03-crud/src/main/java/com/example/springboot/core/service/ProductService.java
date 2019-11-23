package com.example.springboot.core.service;

import com.example.springboot.core.model.Product;
import com.example.springboot.core.model.Store;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:26
 * @description:
 */
public interface ProductService {
    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 通过新建的商品名跟单价保存
     * @param name
     * @param price
     */
    void save(String name, BigDecimal price);

    /**
     * 通过原有的商品id更新
     * @param id
     * @param name
     * @param price
     */
    void updata(Integer id, String name, BigDecimal price);

    /**
     * 查找所有的商品信息
     * @return
     */
    List<Product> findAll();

    /**
     * 通过id删除商品信息
     * @param id
     */
    void delete(Integer id);

    /**
     * 通过商品名查找
     * @param string
     * @return
     */
    List<Product> findByName(String string);


}
