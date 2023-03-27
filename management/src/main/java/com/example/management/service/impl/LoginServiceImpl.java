package com.example.management.service.impl;

import com.example.management.domain.LoginStaff;
import com.example.management.pojo.Staff;
import com.example.management.service.LoginService;
import com.example.management.utils.CommonResult;
import com.example.management.utils.JwtUtil;
import com.example.management.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public CommonResult login(Staff staff) {
        //System.out.println("nihao");

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(staff.getStaffAccount(),staff.getStaffPassword());
        System.out.println("验证1");
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authenticate)){
            return CommonResult.error(400,"用户名不存在");
        }
        LoginStaff loginStaff = (LoginStaff)authenticate.getPrincipal();
        if(Objects.isNull(loginStaff)){
            return CommonResult.error(400,"用户名或密码错误");
        }
        String staffAccount = loginStaff.getStaff().getStaffAccount().toString();
        String jwt = JwtUtil.createJWT(staffAccount);
        Map<String,String> map = new HashMap<>();
        //System.out.println("hello");
        map.put("staffId",loginStaff.getStaff().getStaffId().toString());
        if(loginStaff.getStaff().getStaffName().toString() != null){
            map.put("staffName",loginStaff.getStaff().getStaffName().toString());
        }
        map.put("token",jwt);
        redisCache.setCacheObject("login" + staffAccount,loginStaff);
        return CommonResult.success(map);
    }

    @Override
    public CommonResult logout() {
        //从SecurityContextHolder中的userid
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        LoginStaff loginUser = (LoginStaff) authentication.getPrincipal();
        String staffAccount = loginUser.getStaff().getStaffAccount();
        System.out.println("logout");
        //根据userid找到redis对应值进行删除
        redisCache.deleteObject("login"+ staffAccount);
        return CommonResult.success();
    }

}
