package com.example.management.service;

import com.example.management.pojo.Followup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.management.utils.CommonResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zerowo
 * @since 2023-03-31
 */
public interface FollowupService extends IService<Followup> {

    CommonResult addFollowup(Followup followup);

    CommonResult allFollowup();

    CommonResult selectCustomerFollowup(String customerId);

    CommonResult selectStaffFollowup(String staffId);
}
