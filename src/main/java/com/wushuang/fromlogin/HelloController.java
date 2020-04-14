package com.wushuang.fromlogin;


import com.wushuang.fromlogin.mapper.UserMapper;
import com.wushuang.fromlogin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;



    @GetMapping("/hello")
    public List<User> hello(){
        return userMapper.selectList(null);
    }

}
