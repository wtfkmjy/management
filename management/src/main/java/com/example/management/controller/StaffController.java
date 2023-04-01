package com.example.management.controller;


import com.example.management.pojo.Staff;
import com.example.management.service.StaffService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PreAuthorize("hasAuthority('获取员工信息')")
    @GetMapping("/select")
    public CommonResult selectAll(){
        return staffService.selectAll();
    }

    @PreAuthorize("hasAuthority('获取员工信息')")
    @PostMapping("/select/department")
    public CommonResult selectByDepartment(String departmentName){
        return staffService.selectByDepartment(departmentName);
    }

    @PreAuthorize("hasAuthority('获取员工信息')")
    @PostMapping("/select/job")
    public CommonResult selectByJob(Staff staff){
        System.out.println(staff);
        return staffService.selectByJob(staff);
    }

    @PreAuthorize("hasAuthority('添加与修改员工')")
    @PostMapping("/account")
    public CommonResult setAccount(Staff staff){
        return staffService.setAccount(staff);
    }

    @PreAuthorize("hasAuthority('添加与修改员工')")
    @PostMapping("/update")
    public CommonResult updateStaff(Staff staff){
        return staffService.updateStaff(staff);
    }
}

