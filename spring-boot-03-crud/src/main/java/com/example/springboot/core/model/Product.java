package com.example.springboot.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: huu
 * @date: 2019/10/17 18:23
 * @description:
 */
@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private BigDecimal price;

    @Column
    private String name;

    /**
     * merge   更新
     * refresh 获取
     * persist 保存
     * remove  删除
     */
    @ManyToMany(mappedBy = "listProduct",fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnoreProperties({"listEmployee","listProduct"})
    private List<Store> listStore = new ArrayList<Store>();
}
