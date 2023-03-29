package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.pojo.Role;
import com.example.management.mapper.RoleMapper;
import com.example.management.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Override
    public CommonResult newRole(Role role) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("roleName",role.getRoleName());
        if(!Objects.isNull(roleMapper.selectOne(wrapper))){
            return CommonResult.error(400,"该角色已存在");
        }
        roleMapper.insert(role);
        return CommonResult.success();
    }
}
