package com.cloud.service.controller;

import com.cloud.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class ServiceController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index() {
        List<ServiceInstance> instances = client.getInstances("Hello-Service");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "  " + instance.getServiceId());
        }
        return "hello world";
    }

    @RequestMapping("/hystrix")
    public String hystrix() throws InterruptedException {
        Thread.sleep(new Random().nextInt(3000));
        return "hello hystrix";
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {
        return "hello1 " + name;
    }

    @RequestMapping("/hello2")
    public User hello2(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello3(@RequestBody User user) throws InterruptedException {
        Thread.sleep(1000);
        return "hello3 " + user.getName() + user.getAge();
    }

    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    public String hello4(@RequestBody User user) {
        throw new RuntimeException("服务端测试异常！");
    }

    @RequestMapping(value = "/hello5", method = RequestMethod.POST)
    public String hello5(@RequestBody User user) throws InterruptedException {
        Thread.sleep(6000);
        return "hello3 " + user.getName() + user.getAge();
    }
}
