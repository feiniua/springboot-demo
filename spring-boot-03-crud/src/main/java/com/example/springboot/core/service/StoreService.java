package com.example.springboot.core.service;

import com.example.springboot.core.model.Store;

import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:09
 * @description:
 */
public interface StoreService {
    /**
     * 根据id查询商店
     * @param id
     * @return
     */
    Store findById(Integer id);

    /**
     * 根据 商店名 跟 商品id号 保存商店
     * @param name
     * @param productsId
     */
    void save(String name, Integer[] productsId);

    /**
     * 根据商店id更新商店信息
     * @param id
     * @param name
     * @param productsId
     */
    void save(Integer id, String name, Integer[] productsId);

    /**
     * 删除商店
     * @param store
     */
    void delete(Store store);

    /**
     * 寻找所有的商店信息
     * @return
     */
    List<Store> findAll();

    /**
     * 通过商店名寻找商店
     * @param string
     * @return
     */
    List<Store> findByName(String string);

}
