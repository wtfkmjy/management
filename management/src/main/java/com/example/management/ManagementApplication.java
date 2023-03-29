package com.example.management;

import com.example.management.mapper.ChatMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan("com.example.management.mapper")
public class ManagementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run=SpringApplication.run(ManagementApplication.class, args);

    }

}
