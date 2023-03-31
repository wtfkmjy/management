package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.mapper.ManuMapper;
import com.example.management.mapper.RoleMapper;
import com.example.management.pojo.Manu;
import com.example.management.pojo.Role;
import com.example.management.pojo.RoleManu;
import com.example.management.mapper.RoleManuMapper;
import com.example.management.service.RoleManuService;
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
public class RoleManuServiceImpl extends ServiceImpl<RoleManuMapper, RoleManu> implements RoleManuService {
    @Autowired(required = false)
    private  RoleManuMapper roleManuMapper;

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Autowired(required = false)
    private ManuMapper manuMapper;

    @Override
    public CommonResult setRoleManu(String roleName, String manuName) {
        QueryWrapper wrapper1 = new QueryWrapper();
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper1.eq("roleName",roleName);
        wrapper2.eq("manuName",manuName);
        Role role = roleMapper.selectOne(wrapper1);
        Manu manu = manuMapper.selectOne(wrapper2);
        if(Objects.isNull(role) || Objects.isNull(manu)){
            return CommonResult.error(400,"角色或权限不存在");
        }
        wrapper1.eq("manuName",manuName);
        Integer integer = roleManuMapper.selectCount(wrapper1);
        if(integer > 0){
            return CommonResult.error(400,"该角色已有此权限");
        }
        roleManuMapper.insert(new RoleManu(role.getRoleId(),roleName,manu.getManuId(),manuName));
        return CommonResult.success();
    }
}
