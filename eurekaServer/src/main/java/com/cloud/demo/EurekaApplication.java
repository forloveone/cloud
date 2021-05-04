package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    //1,构建注册中心  解决了服务实例维护问题  进阶是配置集群解决单点故障
    //1,1 高可用注册中心
    //2,服务注册和发现
    //http://localhost:10001/
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
