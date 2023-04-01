package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.mapper.CustomerMapper;
import com.example.management.mapper.StaffMapper;
import com.example.management.pojo.Customer;
import com.example.management.pojo.Followup;
import com.example.management.mapper.FollowupMapper;
import com.example.management.pojo.Staff;
import com.example.management.service.FollowupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zerowo
 * @since 2023-03-31
 */
@Service
public class FollowupServiceImpl extends ServiceImpl<FollowupMapper, Followup> implements FollowupService {
    @Autowired(required = false)
    private FollowupMapper followupMapper;

    @Autowired(required = false)
    private StaffMapper staffMapper;

    @Autowired(required = false)
    private CustomerMapper customerMapper;

    @Override
    public CommonResult addFollowup(Followup followup) {
        QueryWrapper wrapper1 = new QueryWrapper();
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper1.eq("staffQQ",followup.getStaffQQ());
        wrapper2.eq("customerQQ",followup.getCustomerQQ());
        Staff staff = staffMapper.selectOne(wrapper1);
        Customer customer = customerMapper.selectOne(wrapper2);
        if(Objects.isNull(staff) || Objects.isNull(customer)){
            return CommonResult.error(400,"用户或客户不存在");
        }
        followup.setStaffId(staff.getStaffId());
        followup.setCustomerId(customer.getCustomerId());
        followup.setStaffName(staff.getStaffName());
        followup.setCustomerName(customer.getCustomerName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        followup.setEntryTime(sdf.format(System.currentTimeMillis()));
        followupMapper.insert(followup);
        return CommonResult.success();
    }

    @Override
    public CommonResult allFollowup() {
        List<Followup> followups = followupMapper.selectList(null);
        return CommonResult.success(followups);
    }

    @Override
    public CommonResult selectCustomerFollowup(String customerId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("customerId",customerId);
        List list = followupMapper.selectList(wrapper);
        return CommonResult.success(list);
    }

    @Override
    public CommonResult selectStaffFollowup(String staffId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("staffId",staffId);
        List list = followupMapper.selectList(wrapper);
        return CommonResult.success(list);
    }
}
