package com.wushuang.fromlogin.config;

import com.wushuang.fromlogin.pojo.Student;
import com.wushuang.fromlogin.pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private static List<Student> testFilter(List<Student> students){


        //filter(筛选)
       /* //筛选年龄大于15岁的学生
        return students.stream().filter(s -> s.getAge() > 15).collect(Collectors.toList());*/
        //筛选住在浙江省的学生
        return students.stream().filter(s -> "浙江".equals(s.getAddress())).collect(Collectors.toList());

    }

    //集合转换
    private static void testMap(List<Student> students){
        //在地址前面加上部分信息,只获取地址输出
        List<String> addresses = students.stream().map(s -> "住址:" + s.getAddress()).collect(Collectors.toList());

        addresses.forEach(a->System.out.println(a));


    }
    //去重
    private static void testDistinct(){
        //简单字符串去重
        List<String> list = Arrays.asList("111", "222", "333", "111", "222");
        list.stream().distinct().forEach(System.out::println);
    }
    //集合去重(引用对象)
    private static void testDistinct2(){
        //引用对象的去重,引用对象实现hashcode和equals方法,否则去重无效
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "老王", 17, "浙江");
        Student s5 = new Student(1L, "肖战", 15, "浙江");

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.stream().distinct().forEach(System.out::println);
    }
    //集合排序(默认排序)
    private static void testSort(){
        List<Integer> lists = Arrays.asList(21, 2, 3, 4, 5);
        lists.stream().sorted().forEach(System.out::println);

    }






    public static void main(String[] args) {

        Student s1 = new Student(1L, "老王", 16, "陕西");
        Student s2 = new Student(2L, "小王", 16, "重庆");
        Student s3 = new Student(3L, "阿黑", 11, "浙江");
        Student s4 = new Student(4L, "小黑", 11, "湖北");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        List<Student> streamStudents = testFilter(students);
        streamStudents.forEach(System.out::println);

        testMap(students);
        testDistinct();
        testDistinct2();
        testSort();




    }
}
