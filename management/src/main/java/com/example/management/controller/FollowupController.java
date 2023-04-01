package com.example.management.controller;


import com.example.management.pojo.Followup;
import com.example.management.service.FollowupService;
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
 * @since 2023-03-31
 */
@RestController
@RequestMapping("/followup")
@CrossOrigin
public class FollowupController {
    @Autowired
    private FollowupService followupService;

    @PreAuthorize("hasAuthority('联系跟进')")
    @PostMapping("/add")
    public CommonResult addFollowup(Followup followup){
        return followupService.addFollowup(followup);
    }

    @PreAuthorize("hasAuthority('联系跟进')")
    @PostMapping("/all")
    public CommonResult allFollowup(){
        return followupService.allFollowup();
    }

    @PreAuthorize("hasAuthority('联系跟进')")
    @PostMapping("/customer")
    public CommonResult selectCustomerFollowup(String customerId){
        return followupService.selectCustomerFollowup(customerId);
    }

    @PreAuthorize("hasAuthority('联系跟进')")
    @PostMapping("/staff")
    public CommonResult selectStaffFollowup(String staffId){
        return followupService.selectStaffFollowup(staffId);
    }
}

