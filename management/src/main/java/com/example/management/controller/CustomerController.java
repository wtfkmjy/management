package com.example.management.controller;


import com.example.management.pojo.Customer;
import com.example.management.service.CustomerService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasAuthority('获取客户信息')")
    @PostMapping("/select")
    public CommonResult selectAll(){
        return customerService.selectAll();
    }

    @PreAuthorize("hasAuthority('添加与修改客户')")
    @PostMapping("/add")
    public CommonResult addCustomer(Customer customer){
        return customerService.addCustomer(customer);
    }

    @PreAuthorize("hasAuthority('删除客户')")
    @PostMapping("/delete")
    public CommonResult deleteCustomer(int customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PreAuthorize("hasAuthority('获取客户信息')")
    @PostMapping("/select/id")
    public CommonResult selectById(int customerId){
        return customerService.selectById(customerId);
    }

    @PreAuthorize("hasAuthority('添加与修改客户')")
    @PostMapping("/update")
    public CommonResult updateCustomer(Customer customer){
        return customerService.updateCustomer(customer);
    }



}

