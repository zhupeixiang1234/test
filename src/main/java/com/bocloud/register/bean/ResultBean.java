package com.bocloud.register.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by EDZ on 2019/4/9.
 */
@Getter
@Setter
public class ResultBean {
    private int resultCode;//注册失败-1，注册成功1，用户名不存在-2，密码错误0，登录成功2,用户名已存在-3
    private String message;
    private boolean isSuccess;
}
