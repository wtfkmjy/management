package com.example.management.controller;

import com.example.management.pojo.Staff;
import com.example.management.service.LoginService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/user/login")
    public CommonResult login(Staff staff) {
        System.out.println(staff);
        return loginService.login(staff);
    }

    @PostMapping("/user/logout")
    public CommonResult logout() {
        return loginService.logout();
    }
}
