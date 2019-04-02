package com.springboot.jap_demo.service;

import com.springboot.jap_demo.JapDemoApplicationTests;
import com.springboot.jap_demo.entity.EntityBean;
import com.springboot.jap_demo.entity.UserBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestService extends JapDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        UserBean bean = userService.findOne("1");
        System.out.println(bean);
    }

    @Test
    public void test2() {
        EntityBean entity = userService.findEntity("1");
        System.out.println(entity);
    }

    @Test
    public void test3() {
        List<EntityBean> entity = userService.findEntityById("1");
        for(EntityBean bean : entity) {
            System.out.println(bean);
        }
    }

}
