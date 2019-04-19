package com.bocloud.register.controller;

import com.bocloud.register.Util.MD5Util;
import com.bocloud.register.bean.ResultBean;
import com.bocloud.register.service.UserService;
import com.bocloud.register.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EDZ on 2019/4/9.
 */
@RestController
@RequestMapping(value="/user")
public class UserHandler {
    private final static  Logger logger =  LoggerFactory.getLogger(UserHandler.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ResultBean register(@RequestBody User user){
        if(userService.checkUserName(user)==0){
            try {
                user.setPassword(MD5Util.toMd5(user.getPassword()));
            } catch (Exception e) {
                logger.error(e.toString());
                e.printStackTrace();
            }
            return userService.register(user);
        }
        else{
            ResultBean resultBean = new ResultBean();
            resultBean.setMessage("用户名已存在，请重新输入！");
            resultBean.setSuccess(false);
            resultBean.setResultCode(-3);
            return resultBean;
        }
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResultBean login(@RequestBody User user){
        ResultBean resultBean = new ResultBean();
        if(userService.checkUserName(user)==1){
            try {
                user.setPassword(MD5Util.toMd5(user.getPassword()));
            } catch (Exception e) {
                logger.error(e.toString());
                e.printStackTrace();
            }
            resultBean = userService.login(user);
        }
        else{
            resultBean.setMessage("用户名不存在");
            resultBean.setSuccess(false);
            resultBean.setResultCode(-2);
        }
        return resultBean;
    }

    @RequestMapping(value="selectUserInfo",method = RequestMethod.POST)
    public User selectUserInfo(@RequestBody User user){
        User u=  userService.selectUserInfo(user);
        u.setPassword(null);
        return u;
    }


}
