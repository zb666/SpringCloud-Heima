package com.itheima.client.fallback;

import com.itheima.client.UserClient;
import com.itheima.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryById(Long id) {
        User user = new User();
        user.id = id;
        user.userName = "用户异常";
        return user;
    }

}
