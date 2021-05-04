package com.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 请求合并器
 * 虽然请求合并可以减少请求的数量以缓解service的压力,但是它也有额外开销
 * 用于合并请求的时间窗,会导致请求延迟增高.
 * 是否使用主要考虑
 * 请求命令本身的延迟,如果比较高,可以使用
 * 延迟时间窗内的并发量.如果很低,并不适合使用
 */
@Service
public class HystrixCollapserTest {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 时间窗口为100毫秒
     */
    @HystrixCollapser(batchMethod = "findAll", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "100")})
    public User find(Long id) {
        return null;
    }

    @HystrixCommand
    public List<User> findAll(List<Long> ids) {
        return (List<User>) restTemplate.getForEntity("http://HELLO-SERVICE/allUser?ids={1}", List.class, StringUtils.join(ids, ","));
    }
}
