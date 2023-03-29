package com.example.management.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.example.management.utils.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.serializer.DefaultDeserializer;
import org.springframework.core.serializer.DefaultSerializer;
import org.springframework.core.serializer.Deserializer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

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
        RequestBuilder request = post("http://localhost:9090/user/login")
                .param("staffAccount","abc")
                .param("staffPassword","123456");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            Assertions.assertEquals(result.getCode(), 200);
            JSONObject jsonObject=JSON.parseObject(response);
            Assertions.assertNotNull(jsonObject.get("data"));
            Assertions.assertNotNull(jsonObject.getJSONObject("data").getString("token"));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Test
    void accountError() {  //测试账号错误
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/user/login")
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
        RequestBuilder request = post("http://localhost:9090/user/login")
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
    void logoutSuccess() {  //成功注销
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/user/logout")
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwOTllYTYzMTYwMzg0N2JhODE1ZDhjYzg5YzE2ZmZmNCIsInN1YiI6ImFiYyIsImlzcyI6Ind0ZmttankiLCJpYXQiOjE2NzkyMjY2MDMsImV4cCI6MTY3OTIzMDIwM30.-GYSwFk0H9_PnN9T9FGLdLewVZOKEEGvKCx892p1tGk");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            System.out.println(result);
            Assertions.assertEquals(result.getCode(), 200);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void logoutError() {  //注销失败
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/user/logout");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            System.out.println(result);
            Assertions.assertEquals(result.getCode(), 400);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}