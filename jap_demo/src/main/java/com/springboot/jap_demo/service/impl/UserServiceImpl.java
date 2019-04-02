package com.springboot.jap_demo.service.impl;

import com.springboot.jap_demo.dao.UserRepository;
import com.springboot.jap_demo.entity.EntityBean;
import com.springboot.jap_demo.entity.UserBean;
import com.springboot.jap_demo.service.UserService;
import com.springboot.jap_demo.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserBean findOne(String id) {
        Optional<UserBean> userBean = userRepository.findById("1");
        UserBean bean = userBean.get();
        return bean;
    }

    @Override
    public EntityBean findEntity(String id) {
        List<Object[]> entiry = userRepository.findEntiry("1");
        List<EntityBean> entityBeans = EntityUtils.castEntiry(entiry, new EntityBean(), EntityBean.class);
        if (entityBeans.isEmpty() || entityBeans.size() == 0) {
            return null;
        }
        return entityBeans.get(0);
    }

    @Override
    public List<EntityBean> findEntityById(String id) {
        List<EntityBean> list = userRepository.findEntityById("1");
        return list;
    }
}
