package com.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixTest {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hystrixTest")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String hystrixTest() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/notThisUrl", String.class).getBody();
    }

    public String fallBack(Throwable e){
        return "this is fallback call return:"+e.getMessage();
    }
}
