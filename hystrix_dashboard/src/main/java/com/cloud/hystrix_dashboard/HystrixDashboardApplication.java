package com.cloud.hystrix_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
    /**
     * 只能监控单个的服务,需要监控多个需要配合turbine使用
     *
     * @param args
     */
    //http://localhost:9004/hystrix 访问地址
    //页面可以启动,但是效果没有出来
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
