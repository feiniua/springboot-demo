package com.example.springboot.core.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: huu
 * @date: 2019/10/17 18:08
 * @description:
 */
@Entity
@Setter
@Getter
public class  Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


    @OneToMany(mappedBy = "store",fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnoreProperties("store")
    private List<Employee> listEmployee = new ArrayList<Employee>();

    @ManyToMany
    @JsonIgnoreProperties("listStore")
    @JoinTable(name = "store_product",
            joinColumns = {@JoinColumn(name = "store_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id",referencedColumnName = "id")})
    private List<Product> listProduct = new ArrayList<Product>();
}
