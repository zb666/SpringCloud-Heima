package com.itheima.user.controller;

import com.itheima.user.pojo.User;
import com.itheima.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${test.name}")
    private String name;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        //读取的是远程的heima配置文件
        System.out.println("读取到的配置文件的test.name为: "+name);
        return userService.queryById(id);
    }

}
