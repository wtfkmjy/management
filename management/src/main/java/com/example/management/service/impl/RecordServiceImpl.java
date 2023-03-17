package com.example.management.service.impl;

import com.example.management.pojo.Record;
import com.example.management.mapper.RecordMapper;
import com.example.management.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

}
