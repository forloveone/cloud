package com.cloud.consumer_feign.controller;

import com.cloud.consumer_feign.pojo.User;
import com.cloud.consumer_feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/toHello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping("/toHello1")
    public String hello1() {
        return helloService.hello1("123");
    }

    @RequestMapping("/toHello2")
    public User hello2() {
        return helloService.hello2("我们",22);
    }

    @RequestMapping("/toHello3")
    public String hello3() {
        User user = new User();
        user.setAge(111);
        user.setName("women我们");
        return helloService.hello3(user);
    }

    @RequestMapping("/toHello4")
//    @HystrixCommand(fallbackMethod="fallback") //这种实现方式被 @FeignClient(value = "hello-service",fallback = HelloServiceFallBack.class) 替代了
    public String hello4() {
        User user = new User();
        user.setAge(111);
        user.setName("women我们");
        return helloService.hello4(user);
    }

    public String fallback(){
        return "服务超时";
    }

    @RequestMapping("/toHello5")
    public String hello5() {
        User user = new User();
        user.setAge(111);
        user.setName("women我们");
        return helloService.hello5(user);
    }
}
