package com.example.management.service;

import com.example.management.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.management.utils.CommonResult;
import org.springframework.stereotype.Service;

public interface CustomerService extends IService<Customer> {

    CommonResult selectAll();

    CommonResult addCustomer(Customer customer);

    CommonResult deleteCustomer(int customerId);

    CommonResult selectById(int customerId);

    CommonResult updateCustomer(Customer customer);
}
