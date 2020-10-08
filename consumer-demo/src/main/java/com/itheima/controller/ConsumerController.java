package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
//        String url = "http://localhost:9091/user/8";
//        return restTemplate.getForObject(url,User.class);
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = serviceInstanceList.get(0);
//        StringBuilder userServiceUrl = new StringBuilder().append("http://").append(instance.getHost()).append(":")
//                .append(instance.getPort())
//                .append("/user/")
//                .append(id);
        String url = "http://user-service/user/"+id;
        return restTemplate.getForObject(url.toString(),User.class);
    }

}
