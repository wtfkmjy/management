package com.example.management.service.impl;

import com.example.management.pojo.Chat;
import com.example.management.mapper.ChatMapper;
import com.example.management.service.ChatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements ChatService {
    @Autowired(required = false)
    private ChatMapper chatMapper;

    @Override
    public CommonResult selectAll() {  //查询所有群聊
        List<Chat> chats = chatMapper.selectList(null);
        return CommonResult.success(chats);
    }
}
