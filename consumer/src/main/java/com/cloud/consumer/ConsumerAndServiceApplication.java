package com.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
////服务注册
//@EnableDiscoveryClient
////断路器
//@EnableCircuitBreaker
//包含上面3个注解
@SpringCloudApplication
public class ConsumerAndServiceApplication {
    //开启客户端负载均衡
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAndServiceApplication.class, args);
    }

}
