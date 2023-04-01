package com.example.management.service;

import com.example.management.pojo.StaffRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.management.utils.CommonResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zerowo
 * @since 2023-03-28
 */
public interface StaffRoleService extends IService<StaffRole> {

    CommonResult setStaffRole(int staffId, int roleId);

    CommonResult selectStaffRole(int staffId);
}
