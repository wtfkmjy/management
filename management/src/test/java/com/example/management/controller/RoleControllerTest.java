package com.example.management.controller;

import com.example.management.pojo.Role;
import com.example.management.utils.CommonResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class RoleControllerTest {
    @Autowired
    private RoleController roleController;
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext wac;
    @BeforeEach
    void setup(){
        mvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @WithMockUser(authorities = {"设置权限"})
    void add(){
        Role role=new Role();
        CommonResult commonResult=roleController.newRole(role);
        Assertions.assertEquals(commonResult.getCode(),200);
    }


}
