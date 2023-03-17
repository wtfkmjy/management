package com.example.management.service.impl;

import com.example.management.pojo.Connection;
import com.example.management.mapper.ConnectionMapper;
import com.example.management.service.ConnectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ConnectionServiceImpl extends ServiceImpl<ConnectionMapper, Connection> implements ConnectionService {

}
