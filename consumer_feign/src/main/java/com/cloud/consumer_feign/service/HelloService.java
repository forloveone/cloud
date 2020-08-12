package com.cloud.consumer_feign.service;

import com.cloud.consumer_feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 通过Feign 我们只需定义服务绑定接口,以声明式的方法,优雅而简单的实现了服务调用
 */
@FeignClient(value = "hello-service",fallback = HelloServiceFallBack.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello1")
    String hello1(@RequestParam("name") String name);

    @RequestMapping("/hello2")
    User hello2(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello3(@RequestBody User user);

    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    String hello4(@RequestBody User user);

    @RequestMapping(value = "/hello5", method = RequestMethod.POST)
    String hello5(@RequestBody User user);
}
