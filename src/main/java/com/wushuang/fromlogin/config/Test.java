package com.wushuang.fromlogin.config;

import com.wushuang.fromlogin.pojo.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {





        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(1);

        list.stream().distinct().forEach(System.out::println);



        list.forEach(System.out::println);
    }
}
