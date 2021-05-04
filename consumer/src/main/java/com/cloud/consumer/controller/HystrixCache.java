package com.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixCache {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hystrixCache")
    @HystrixCommand(fallbackMethod = "fallBack2")
    @CacheResult
    public String hystrixCache(@CacheKey("id") String id) {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hystrix", String.class).getBody();
    }

    @RequestMapping("/hystrixCache2")
    @HystrixCommand(fallbackMethod = "fallBack2")
    @CacheResult
    public String hystrixCache2(@CacheKey("id") User user) {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hystrix", String.class).getBody();
    }

    @RequestMapping("/hystrixCacheRemove")
    @HystrixCommand(fallbackMethod = "fallBack2")
    @CacheRemove(commandKey = "hystrixCache")
    public String hystrixCacheRemove(@CacheKey("id") User user) {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hystrix", String.class).getBody();
    }
}

class User {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}