package com.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixTest2 {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hystrixTest2")
    @HystrixCommand(fallbackMethod = "fallBack2")
    public String hystrixTest2() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hystrix", String.class).getBody();
    }

    public String fallBack2() {
        return "this is fallback2 call return";
    }
}
