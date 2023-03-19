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

@SpringBootTest
class RecordControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
    }

    @Test
    void selectAllSuccess() {  //成功查询
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = get("http://localhost:9090/record/select")
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
}