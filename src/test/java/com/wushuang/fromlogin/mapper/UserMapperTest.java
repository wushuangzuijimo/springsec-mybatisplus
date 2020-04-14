package com.wushuang.fromlogin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushuang.fromlogin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testSelect(){
        List<User> list = userMapper.selectList(null);





        list.forEach(System.out::println);

    }


    @Test
    public void testInsert(){

        User user = new User();
        user.setAge(33);
        user.setEmail("1234@qq.com");
        user.setName("老黑");
        int insert = userMapper.insert(user);

        System.out.println(insert);


    }

    @Test
    public void testUpdate(){



        User user = new User();
        //通过条件自动拼接动态sql
        user.setId(1242807302717718538L);
        user.setEmail("1234@qq.com");
        user.setName("111");
        user.setAge(21);
        // 注意：updateById 但是参数是一个 对象！
        int i = userMapper.updateById(user);
        System.out.println(i);



    }





    @Test
    public void testSelectById(){

        User user = userMapper.selectById(110);

        System.out.println(user);

    }


    @Test
    //测试乐观锁成功
    public void testOptimisticLocker(){

        //1.查询用户信息
        User user = userMapper.selectById(1L);
        //2.修改用户信息
        user.setName("阿强");
        //3.执行更新操作
        userMapper.updateById(user);
    }
    @Test
    //测试乐观锁失败!多线程下
    public void testOptimisticLockFail(){

        //线程1
        User user = userMapper.selectById(1L);
        user.setName("老王111");

        //模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("老王222");
        userMapper.updateById(user2);




        //自旋锁来多次尝试提交
        userMapper.updateById(user);//如果没有乐观锁就会覆盖插队线程的值


    }

    //测试批量查询
    @Test
    public void testSelsectByBatchId(){
        List<User> list = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        list.forEach(System.out::println);


    }
    //条件查询之一 使用map操作
    @Test
    public void testSelectByBatchId(){
        HashMap<String, Object> map = new HashMap<>();

        map.put("name","老王222");

        List<User> user = userMapper.selectByMap(map);
        user.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void testSelectLimit(){
        //参数一 : 当前页
        //参数二: 页面大小
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
    }


    //测试删除
    @Test
    public void testDelete(){
        int i = userMapper.deleteById(1L);
        System.out.println(i);

    }

    //通过id批量删除
    @Test
    public void testByIdBatch(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1242806708900802562L, 1242807302717718530L, 1242807302717718536L));
        System.out.println(i);
    }
    //通过map删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","sdsad");


        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }
    //逻辑删除
    @Test
    public void testFailDel(){
        int i = userMapper.deleteById(2);
        System.out.println(i);

    }

    @Test
    public void testfind(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }










}