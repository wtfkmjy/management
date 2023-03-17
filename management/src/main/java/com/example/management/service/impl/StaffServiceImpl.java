package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.pojo.Staff;
import com.example.management.mapper.StaffMapper;
import com.example.management.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {
    @Autowired(required = false)
    private StaffMapper staffMapper;

    @Override
    public CommonResult selectAll() {
        List<Staff> staff = staffMapper.selectList(null);
        return CommonResult.success(staff);
    }

    @Override
    public CommonResult selectByDepartment(String departmentName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("department",departmentName);
        List list = staffMapper.selectList(wrapper);
        return CommonResult.success(list);
    }

    @Override
    public CommonResult selectByJob(Staff staff) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("staffJob",staff.getStaffJob());
        List list = staffMapper.selectList(wrapper);
        System.out.println(list);
        return CommonResult.success(list);
    }

    @Override
    public CommonResult setAccount(String staffAccount, String staffPassword, String confirmPassword) {
        if(!staffPassword.equals(confirmPassword)){
            return CommonResult.error(400,"密码不一致");
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("staffAccount",staffAccount);
        if(staffMapper.selectCount(wrapper) > 0){
            return CommonResult.error(400,"账号已被注册");
        }
        Staff staff = new Staff();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        staff.setStaffPassword(bCryptPasswordEncoder.encode(staff.getStaffPassword()));
        staffMapper.insert(staff);
        return CommonResult.success();
    }
}
