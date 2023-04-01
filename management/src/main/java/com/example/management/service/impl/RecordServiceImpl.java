package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.pojo.Record;
import com.example.management.mapper.RecordMapper;
import com.example.management.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {
    @Autowired(required = false)
    private RecordMapper recordMapper;

    @Override
    public CommonResult selectAll() {
        List<Record> records = recordMapper.selectList(null);
        return CommonResult.success(records);
    }

    @Override
    public CommonResult selectById(int customerId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("personId",customerId);
        List list = recordMapper.selectList(wrapper);
        return CommonResult.success(list);
    }

    @Override
    public CommonResult selectByChatId(int chatId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("chatId",chatId);
        List list = recordMapper.selectList(wrapper);
        return CommonResult.success(list);
    }
}
