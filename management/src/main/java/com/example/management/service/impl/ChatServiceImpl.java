package com.example.management.service.impl;

import com.example.management.pojo.Chat;
import com.example.management.mapper.ChatMapper;
import com.example.management.service.ChatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements ChatService {

}
