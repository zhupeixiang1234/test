package com.bocloud.register.mapper;

import com.bocloud.register.bean.ResultBean;
import com.bocloud.register.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by EDZ on 2019/4/9.
 */
@Component
@Mapper
public interface UserMapper {

    public int register(User user);

    public User checkUserName(User user);

    public User login(User user);

    public User selectUserInfo(User user);
}
