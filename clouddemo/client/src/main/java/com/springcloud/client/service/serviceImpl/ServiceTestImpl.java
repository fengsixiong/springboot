package com.springcloud.client.service.serviceImpl;

import com.springcloud.client.service.IServiceTest;
import org.springframework.stereotype.Service;

@Service
public class ServiceTestImpl implements IServiceTest {


    @Override
    public String getString() {
        return " log - invoke serviceTest success";
    }
}
