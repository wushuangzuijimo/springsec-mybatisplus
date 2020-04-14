package com.wushuang.fromlogin.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {




    @TableId(type =IdType.AUTO)

    //对应数据库中的主键(uuid 自增id 雪花算法 redis zookeeper)
    private Long id;
    private String name;
    private Integer age;
    private String email;


    @Version//乐观锁version注解
    private Integer version;

    @TableLogic //逻辑删除
    private Integer deleted;

    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;



}
