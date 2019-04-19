package com.bocloud.register.service;

import com.bocloud.register.bean.ResultBean;
import com.bocloud.register.vo.User;

/**
 * Created by EDZ on 2019/4/9.
 */
public interface UserService {

    public ResultBean register(User user);

    public int checkUserName(User user);

    public ResultBean login(User user);

    public User selectUserInfo(User user);
}
