package com.example.management.service;

import com.example.management.pojo.Staff;
import com.example.management.utils.CommonResult;

public interface LoginService {
    CommonResult login(Staff staff);

    CommonResult logout();
}
