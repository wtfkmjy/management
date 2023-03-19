package com.example.management.controller;

import com.example.management.utils.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class LoginControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
    }

    @Test
    void loginSuccess() {  //测试成功登录
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/login")
                .param("staffAccount","abcdeeeee")
                .param("staffPassword","123456");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            System.out.println(result);
            System.out.println(result.getData());
            Assertions.assertEquals(result.getCode(), 200);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void accountError() {  //测试账号错误
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/login")
                .param("staffAccount","abcdeeee")
                .param("staffPassword","123456");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            System.out.println(result);
            System.out.println(result.getCode());
            Assertions.assertEquals(result.getCode(), 400);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void passwordError() {  //测试账号错误
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/login")
                .param("staffAccount","abcdeeeee")
                .param("staffPassword","1234");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            System.out.println(result);
            System.out.println(result.getCode());
            Assertions.assertEquals(result.getCode(), 400);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void logout() {
    }
}