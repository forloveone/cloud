package com.cloud.consumer_feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigRefresh {
    @Value("${from}")
    String from;

    @RequestMapping("/from")
    public String refresh() {
        return from;
    }
}
