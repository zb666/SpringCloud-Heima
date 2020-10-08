package com.itheima.controller;

import com.itheima.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    @HystrixCommand
    public User queryById(@PathVariable Long id){
//        String url = "http://localhost:9091/user/8";
//        return restTemplate.getForObject(url,User.class);
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = serviceInstanceList.get(0);
//        StringBuilder userServiceUrl = new StringBuilder().append("http://").append(instance.getHost()).append(":")
//                .append(instance.getPort())
//                .append("/user/")
//                .append(id);
        if(id == 8){
            throw new RuntimeException("太忙了");
        }
//        String url = "http://user-service/user/"+id;
         String url = "http://localhost:9091/user/8";
        return restTemplate.getForObject(url.toString(),User.class);
    }

    public String queryIdFallback(Long id){
        return "对不起，网络太拥挤了";
    }

    public String defaultFallback(){
        return "对不起吗，网络太拥堵了";
    }

}
