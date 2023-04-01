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
public class RoleManuServiceImpl extends ServiceImpl<RoleManuMapper, RoleManu> implements RoleManuService {
    @Autowired(required = false)
    private  RoleManuMapper roleManuMapper;

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Autowired(required = false)
    private ManuMapper manuMapper;

    @Override
    public CommonResult setRoleManu(int roleId, int manuId) {
        QueryWrapper wrapper1 = new QueryWrapper();
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper1.eq("roleId",roleId);
        wrapper2.eq("manuId",manuId);
        Role role = roleMapper.selectOne(wrapper1);
        Manu manu = manuMapper.selectOne(wrapper2);
        if(Objects.isNull(role) || Objects.isNull(manu)){
            return CommonResult.error(400,"角色或权限不存在");
        }
        wrapper1.eq("manuId",manuId);
        Integer integer = roleManuMapper.selectCount(wrapper1);
        if(integer > 0){
            return CommonResult.error(400,"该角色已有此权限");
        }
        roleManuMapper.insert(new RoleManu(roleId,role.getRoleName(),manuId,manu.getManuName()));
        return CommonResult.success();
    }

    @Override
    public CommonResult selectRoleManu(String roleId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("roleId",roleId);
        List list = roleManuMapper.selectList(wrapper);
        return CommonResult.success(list);
    }
}
