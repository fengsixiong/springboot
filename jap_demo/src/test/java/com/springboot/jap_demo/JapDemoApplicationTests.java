package com.springboot.jap_demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JapDemoApplication.class)
@WebAppConfiguration
public class JapDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Before
    public void Init() {
        System.out.println(" ------   begin  test  ------ ");
    }

    @After
    public void end() {
        System.out.println(" ------   end  test  ------ ");
    }

}
