package com.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/buy/{id}",method = {RequestMethod.POST,RequestMethod.GET})
    public String Buy(@PathVariable("id") String id){
        System.out.println(" log - id : " + id);
        String str = restTemplate.getForObject("http://CLIENT/getPort", String.class);
        return "port : " + str + " id : " + id;
    }
}
