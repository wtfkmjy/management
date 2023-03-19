package com.example.management.service;

import com.example.management.pojo.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.management.utils.CommonResult;

public interface RecordService extends IService<Record> {

    CommonResult selectAll();

    CommonResult selectById(int customerId);

    CommonResult selectByChatId(int chatId);
}
