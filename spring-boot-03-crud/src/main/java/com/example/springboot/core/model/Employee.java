package com.example.springboot.core.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

/**
 * @author: huu
 * @date: 2019/10/17 17:29
 * @description:
 */
@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    /**
     * json转化时忽略
     *      @Jsonignore
     *
     * json转化时通过指定的property识别只出现一次
     *       @JsonIdentityInfo(
     *                 generator = ObjectIdGenerators.PropertyGenerator.class,
     *                 property = "id"
     *      )
     *
     * 指定的字段不会被序列化
     *       @JsonIgnoreProperties
     */
    @JsonIgnoreProperties({"listEmployee", "listProduct"})
    @ManyToOne(targetEntity = Store.class)
    @JoinColumn(name = "store_id")
    Store store;

}
