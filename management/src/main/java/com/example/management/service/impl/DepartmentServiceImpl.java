package com.example.management.service.impl;

import com.example.management.pojo.Department;
import com.example.management.mapper.DepartmentMapper;
import com.example.management.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
