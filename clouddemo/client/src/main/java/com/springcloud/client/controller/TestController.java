package com.springcloud.client.controller;

import com.springcloud.client.service.IServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    IServiceTest iServiceTest;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/getStr",method = {RequestMethod.POST,RequestMethod.GET})
    public String Test() {
        return iServiceTest.getString();
    }

    @RequestMapping(value = "/getPort",method = {RequestMethod.POST,RequestMethod.GET})
    public String getPort() {
        System.out.println(" log - port : " +port);
        return port;
    }
}
