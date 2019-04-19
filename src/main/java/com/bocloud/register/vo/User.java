package com.bocloud.register.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by EDZ on 2019/4/9.
 */
@Getter
@Setter
public class User implements Serializable{//持久化
    private static final long serialVersionUID = 1L;
    private int id;//数据库主键
    private String username;//用户名、姓名
    private String userRealName;//真实姓名
    private String password;//密码
    private String userMail;//电子邮箱
    private String userPhone;//手机号码
}
