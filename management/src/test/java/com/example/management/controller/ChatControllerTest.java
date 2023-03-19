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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class ChatControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
    }

    @Test
    void selectChat() {  //测试查找所有群聊
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/chat/select")
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4YWZjMTZhY2YxMjA0MTI3OTZiYzExYzM1NzkxMzY2ZCIsInN1YiI6ImFiY2RlZWVlZSIsImlzcyI6Ind0ZmttankiLCJpYXQiOjE2NzkyMzQxNTMsImV4cCI6MTY3OTIzNzc1M30.lSU_4m1CvOfVoifwaUds2SbMPHAwLf4mEdeFJReYqeQ");
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
    void selectChatWithoutRole() {  //测试人事部员工查找群聊
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/chat/select")
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2ZTE5OTVjMTgyMzg0NTViOThlMWY1NGM5NDQ5ZTk2NiIsInN1YiI6ImFiYyIsImlzcyI6Ind0ZmttankiLCJpYXQiOjE2NzkyMzI4NzAsImV4cCI6MTY3OTIzNjQ3MH0.mHvMri7ZJ5R1YcEMycAsGf2T6HUiufGpW-K2Y3I4dD8");
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
}