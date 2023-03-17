package com.example.management.controller;


import com.example.management.pojo.Staff;
import com.example.management.service.StaffService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/select")
    public CommonResult selectAll(){
        return staffService.selectAll();
    }

    @PostMapping("/select/department")
    public CommonResult selectByDepartment(String departmentName){
        return staffService.selectByDepartment(departmentName);
    }

    @PostMapping("/select/job")
    public CommonResult selectByJob(Staff staff){
        System.out.println(staff);
        return staffService.selectByJob(staff);
    }

    @PostMapping("/account")
    public CommonResult setAccount(String staffAccount, String staffPassword, String confirmPassword){
        return staffService.setAccount(staffAccount,staffPassword,confirmPassword);
    }
}

