package com.example.management.service.impl;

import com.example.management.pojo.Customer;
import com.example.management.mapper.CustomerMapper;
import com.example.management.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
