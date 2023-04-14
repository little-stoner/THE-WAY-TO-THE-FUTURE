package com.x.stone.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@RequestMapping("/stone")
public class StoneController {

    @Autowired
    private EurekaClient discoveryClient;

    @Value("${stone.name:#}")
    private String name;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("stone", false);
        return instance.getInstanceId();
    }

    @GetMapping("/name")
    public String stone() {
        return name;
    }

}
