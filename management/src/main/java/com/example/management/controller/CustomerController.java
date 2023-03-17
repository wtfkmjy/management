package com.example.management.controller;


import com.example.management.pojo.Customer;
import com.example.management.service.CustomerService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/select")
    public CommonResult selectAll(){
        return customerService.selectAll();
    }

    @PostMapping("/add")
    public CommonResult addCustomer(Customer customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping("/delete")
    public CommonResult deleteCustomer(String customerId) {
        return customerService.deleteCustomer(customerId);
    }
}

