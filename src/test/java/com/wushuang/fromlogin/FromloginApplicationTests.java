package com.wushuang.fromlogin;

import com.wushuang.fromlogin.mapper.UserMapper;
import com.wushuang.fromlogin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FromloginApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //参数是一个wapper,条件构造器

        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

}
