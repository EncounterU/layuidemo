package com.hh.layuidemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    private Integer employeeId;
    private String name;
    private String sex;
    private String phone;
    private String salary;
    private String departmentId;
    private String departmentName;
    private String password;
    private Integer status;
}
