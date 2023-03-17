package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.pojo.Customer;
import com.example.management.mapper.CustomerMapper;
import com.example.management.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired(required = false)
    private CustomerMapper customerMapper;

    @Override
    public CommonResult selectAll() {
        List<Customer> list = customerMapper.selectList(null);
        return CommonResult.success(list);
    }

    @Override
    public CommonResult addCustomer(Customer customer) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("customerEmail",customer.getCustomerEmail());
        if(customerMapper.selectCount(wrapper) > 0){
            return CommonResult.error(400,"邮箱重复");
        }
        customerMapper.insert(customer);
        return CommonResult.success();
    }

    @Override
    public CommonResult deleteCustomer(String customerId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("customerId",customerId);
        if(customerMapper.selectCount(wrapper) == 0){
            return CommonResult.error(400,"用户不存在");
        }
        customerMapper.delete(wrapper);
        return CommonResult.success();
    }
}
