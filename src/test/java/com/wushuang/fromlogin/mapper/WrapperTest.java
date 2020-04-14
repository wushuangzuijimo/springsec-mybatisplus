package com.wushuang.fromlogin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushuang.fromlogin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        //查询name不为空的用户,并且邮箱不为空的用户 年龄大于12岁的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::println);


    }
    @Test
    void test2(){
        //查询name是老黑的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","老黑");

        Integer integer = userMapper.selectCount(wrapper);
        System.out.println(integer);
    }
    @Test
    void test3(){
        //查询年龄在 20 -30 岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);//区间


        Integer integer = userMapper.selectCount(wrapper);
        System.out.println(integer);
    }
    @Test
    void test4(){
        //模糊查询
        //名字中
        //左 和 右
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name","e")
                .likeRight("email","t");

        /*List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);*/
        List<Object> list = userMapper.selectObjs(wrapper);
        list.forEach(System.out::println);

    }

    @Test
    void test5(){
        //查询

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //id 在子查询中查出来
        wrapper.inSql("id","select id from user where id <3");

        List<Object> list = userMapper.selectObjs(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    void test6(){

        //查询排序 通过id
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");

        List<Map<String, Object>> maps =
                userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);


    }

    @Test
    void test7(){

        String s = System.getProperty("user.dir");
        System.out.println(s);

    }

}
