package com.example.management.mapper;

import com.example.management.pojo.Chat;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface ChatMapper extends BaseMapper<Chat> {

}
