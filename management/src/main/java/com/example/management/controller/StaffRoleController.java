package com.example.management.controller;


import com.example.management.service.StaffRoleService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class StaffRoleController {
    @Autowired
    private StaffRoleService staffRoleService;

    @PreAuthorize("hasAuthority('设置权限')")
    @PostMapping("/add")
    public CommonResult setStaffRole(int staffId, int roleId){
        return staffRoleService.setStaffRole(staffId,roleId);
    }

    @PreAuthorize("hasAuthority('设置权限')")
    @PostMapping("/select")
    public CommonResult selectStaffRole(int staffId){
        return staffRoleService.selectStaffRole(staffId);
    }
}

