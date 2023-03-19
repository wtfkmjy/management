package com.example.management.controller;

import com.example.management.utils.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class StaffControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
    }

    @Test
    void selectAllSuccess() {  //成功查询
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://localhost:9090/staff/select")
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwOTllYTYzMTYwMzg0N2JhODE1ZDhjYzg5YzE2ZmZmNCIsInN1YiI6ImFiYyIsImlzcyI6Ind0ZmttankiLCJpYXQiOjE2NzkyMjY2MDMsImV4cCI6MTY3OTIzMDIwM30.-GYSwFk0H9_PnN9T9FGLdLewVZOKEEGvKCx892p1tGk");
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
    void selectStaffWithoutToken() {  //未登录
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://localhost:9090/staff/select");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            System.out.println(result);
            System.out.println(result.getData());
            Assertions.assertEquals(result.getCode(), 401);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void selectStaffWithoutRole() {  //没有权限
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://localhost:9090/staff/select")
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjYTFmOGFkZGU1MmM0YzkxYWVhY2Q2NjM5NDExYWRjZCIsInN1YiI6ImFiY2RlZWVlZSIsImlzcyI6Ind0ZmttankiLCJpYXQiOjE2NzkyMzA3MDEsImV4cCI6MTY3OTIzNDMwMX0.gVWCblGQ5sEKh7ZEpanSIoiqPd78ZEgNB9PlGuLD-PI");
        try{
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            ObjectMapper mapper = new ObjectMapper();
            CommonResult<?> result = mapper.readerFor(CommonResult.class).readValue(response);
            System.out.println(result);
            System.out.println(result.getData());
            Assertions.assertEquals(result.getCode(), 403);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void selectByDepartment() {  //测试根据部门查询员工
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/staff/select/id")
                .param("department","人事部")
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwOTllYTYzMTYwMzg0N2JhODE1ZDhjYzg5YzE2ZmZmNCIsInN1YiI6ImFiYyIsImlzcyI6Ind0ZmttankiLCJpYXQiOjE2NzkyMjY2MDMsImV4cCI6MTY3OTIzMDIwM30.-GYSwFk0H9_PnN9T9FGLdLewVZOKEEGvKCx892p1tGk");
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
    void selectByJob() {  //测试根据职位查找员工
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/staff/select/job")
                .param("department","主管")
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwOTllYTYzMTYwMzg0N2JhODE1ZDhjYzg5YzE2ZmZmNCIsInN1YiI6ImFiYyIsImlzcyI6Ind0ZmttankiLCJpYXQiOjE2NzkyMjY2MDMsImV4cCI6MTY3OTIzMDIwM30.-GYSwFk0H9_PnN9T9FGLdLewVZOKEEGvKCx892p1tGk");
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
    @Transactional
    @Rollback()
    void setAccount() {  //测试设置员工信息
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = post("http://localhost:9090/staff/add")
                .param("staffName","lisi")
                .param("staffEmail","szu.szu.edu.cn")
                .param("staffGender","男")
                .param("staffAddress","szu")
                .param("staffJob","主管")
                .param("staffPhone","141565195")
                .param("staffAccount","qwer")
                .param("staffPassword","123456")
                .param("department","销售部")
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