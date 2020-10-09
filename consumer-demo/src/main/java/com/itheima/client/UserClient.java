package com.itheima.client;

import com.itheima.client.fallback.UserClientFallback;
import com.itheima.config.FeignConfig;
import com.itheima.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "user-service",
        fallback = UserClientFallback.class,
        configuration = FeignConfig.class)
public interface UserClient {

    //http://user-service/user/123
    @GetMapping("/user/{id}")
    User queryById(@PathVariable Long id);

}
