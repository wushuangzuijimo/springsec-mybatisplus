package com.wushuang.fromlogin.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private Long id;
    private String name;
    private int age;
    private String address;
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address);
    }

    @Override
    public boolean equals(Object obj) {


        if (this == obj) {
            return true;
        }
        if (obj == null || getClass()!= obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address);
    }


}
