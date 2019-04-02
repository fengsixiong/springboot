package com.springboot.jap_demo.bate;

import com.springboot.jap_demo.service.TestService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//打包测试
@RunWith(Suite.class)
//扫描打包类
@Suite.SuiteClasses(TestService.class)
//@Ignore("not ready yet")    在方法上加此标签,忽略某方法
public class TestBate {
}
