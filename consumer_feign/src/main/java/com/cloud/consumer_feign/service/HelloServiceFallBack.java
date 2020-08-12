package com.cloud.consumer_feign.service;

import com.cloud.consumer_feign.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallBack implements HelloService{
    @Override
    public String hello() {
        return "error hello";
    }

    @Override
    public String hello1(String name) {
        return "error hello1";
    }

    @Override
    public User hello2(String name, Integer age) {
        return new User("unknow",0);
    }

    @Override
    public String hello3(User user) {
        return "error hello3";
    }

    @Override
    public String hello4(User user) {
        return "error hello4";
    }

    @Override
    public String hello5(User user) {
        return "error hello5";
    }
}
