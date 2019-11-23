package com.example.springboot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: huu
 * @date: 2019/10/31 16:05
 * @description:
 */
@Controller
public class IndexApi {

    @GetMapping("/")
    public String getIndex() {
       return "index.html";
    }

    @GetMapping("/employeePage")
    public String getEmployee() {
        return "employeePage.html";
    }

    @GetMapping("/productPage")
    public String getProduct() {
        return "productPage.html";
    }

    @GetMapping("/storePage")
    public String getStore() {
        return "storePage.html";
    }

    @GetMapping("/employeeAdd")
    public String employeeAdd(){
        return "employeeAdd.html";
    }

    @GetMapping("/employeeEdit")
    public String employeeEdit() {
        return "employeeEdit.html";
    }

    @GetMapping("/storeAdd")
    public String storeAdd() {
        return "storeAdd.html";
    }

    @GetMapping("/storeEdit")
    public String storeEdit() {
        return "storeEdit.html";
    }

    @GetMapping("/productAdd")
    public String productAdd() {
        return "productAdd.html";
    }

    @GetMapping("productEdit")
    public String productEdit() {
        return "productEdit.html";
    }
}
