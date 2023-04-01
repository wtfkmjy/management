package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.mapper.RoleMapper;
import com.example.management.mapper.StaffMapper;
import com.example.management.pojo.*;
import com.example.management.mapper.StaffRoleMapper;
import com.example.management.service.StaffRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zerowo
 * @since 2023-03-28
 */
@Service
public class StaffRoleServiceImpl extends ServiceImpl<StaffRoleMapper, StaffRole> implements StaffRoleService {
    @Autowired(required = false)
    private StaffRoleMapper staffRoleMapper;

    @Autowired(required = false)
    private StaffMapper staffMapper;

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Override
    public CommonResult setStaffRole(int staffId, int roleId) {
        QueryWrapper wrapper1 = new QueryWrapper();
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper1.eq("staffId",staffId);
        wrapper2.eq("roleId",roleId);
        Staff staff = staffMapper.selectOne(wrapper1);
        Role role = roleMapper.selectOne(wrapper2);
        if(Objects.isNull(role) || Objects.isNull(staff)){
            return CommonResult.error(400,"用户或角色不存在");
        }
        wrapper1.eq("roleId",roleId);
        Integer integer = staffRoleMapper.selectCount(wrapper1);
        if(integer > 0){
            return CommonResult.error(400,"该用户已有此角色类型");
        }
        staffRoleMapper.insert(new StaffRole(staffId,staff.getStaffName(),roleId,role.getRoleName()));
        return CommonResult.success();
    }

    @Override
    public CommonResult selectStaffRole(int staffId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("staffId",staffId);
        List list = staffRoleMapper.selectList(wrapper);
        return CommonResult.success(list);
    }
}
