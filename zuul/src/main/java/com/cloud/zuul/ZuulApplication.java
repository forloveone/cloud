package com.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class ZuulApplication {
    /**
     * 这个只是实现了静态的加载,动态加载需要配合spring cloud config一起实现
     */
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}
