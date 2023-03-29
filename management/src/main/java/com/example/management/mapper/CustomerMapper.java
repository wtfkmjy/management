package com.example.management.mapper;

import com.example.management.pojo.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    Customer selectMyCustomer(int CustomerId);
}
