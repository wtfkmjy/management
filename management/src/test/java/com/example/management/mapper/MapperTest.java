package com.example.management.mapper;

import com.example.management.pojo.Customer;
import com.example.management.pojo.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {
//    @Autowired(required = false)
//    private CustomerMapper customerMapper;
//
//    @Autowired(required = false)
//    private StaffMapper staffMapper;
//
//    @Test
//    public void customerTest(){
//        List<Staff> list= staffMapper.selectList(null);
//        System.out.println(list);
//    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    private ManuMapper manuMapper;

    @Autowired(required = false)
    private CustomerMapper customerMapper;
    @Test
    public void manuMapperTest(){
        List<String> strings = manuMapper.selectPermsById(1);
        //Customer customer = customerMapper.selectMyCustomer(1);
        System.out.println(strings);
    }
//    @Test
//    public void passwordTest(){
//        //PasswordEncoder bCryptPasswordEncoder = new PasswordEncoder();
//        System.out.println(passwordEncoder.encode("123456"));
//    }
//    @Autowired
//    private ChatMapper mapper;
//    @Test
//    public void chatMapperTest(){
//        System.out.println(mapper.selectList(null));
//    }
}
