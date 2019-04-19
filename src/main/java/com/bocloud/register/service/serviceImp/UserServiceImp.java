package com.bocloud.register.service.serviceImp;

import com.bocloud.register.bean.ResultBean;
import com.bocloud.register.mapper.UserMapper;
import com.bocloud.register.service.UserService;
import com.bocloud.register.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by EDZ on 2019/4/9.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultBean register(User user) {
        ResultBean resultBean = new ResultBean();
        if(userMapper.register(user)==1){
            resultBean.setResultCode(1);
            resultBean.setSuccess(true);
            resultBean.setMessage("注册成功！");
        }
        else{
            resultBean.setResultCode(-1);
            resultBean.setSuccess(false);
            resultBean.setMessage("注册失败！");
        }
        return resultBean;
    }

    @Override
    public int checkUserName(User user) {
        return userMapper.checkUserName(user)==null?0:1;
    }

    @Override
    public ResultBean login(User user) {
        ResultBean resultBean = new ResultBean();
        User u = userMapper.login(user);
        if (userMapper.login(user) != null) {
            resultBean.setResultCode(2);
            resultBean.setSuccess(true);
            resultBean.setMessage("登录成功！");
        } else {
            resultBean.setResultCode(0);
            resultBean.setSuccess(false);
            resultBean.setMessage("密码错误！");
        }
        return resultBean;
    }

    @Override
    public User selectUserInfo(User user) {
        return userMapper.selectUserInfo(user);
    }
}
