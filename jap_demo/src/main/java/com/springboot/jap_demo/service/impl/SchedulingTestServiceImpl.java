package com.springboot.jap_demo.service.impl;

import com.springboot.jap_demo.service.SchedulingTestService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "schedulingService")
public class SchedulingTestServiceImpl implements SchedulingTestService {

    @Override
    public void TestPrint() {
        System.out.println(" 执行中  ---  " + new Date().getTime());
    }
}
