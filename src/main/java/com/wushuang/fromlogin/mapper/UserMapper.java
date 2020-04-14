package com.wushuang.fromlogin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wushuang.fromlogin.pojo.User;
import org.springframework.stereotype.Repository;

//在对应的mapper上面继承基本的接口 basemapper
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {



}
