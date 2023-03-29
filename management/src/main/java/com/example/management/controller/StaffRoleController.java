package com.example.management.controller;


import com.example.management.service.StaffRoleService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zerowo
 * @since 2023-03-28
 */
@RestController
@RequestMapping("/staff-role")
public class StaffRoleController {
    @Autowired
    private StaffRoleService staffRoleService;

    @PreAuthorize("hasAuthority('设置权限')")
    @PostMapping("/set")
    public CommonResult setStaffRole(String staffName, String roleName){
        return staffRoleService.setStaffRole(staffName,roleName);
    }
}

