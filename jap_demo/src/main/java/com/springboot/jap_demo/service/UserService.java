package com.springboot.jap_demo.service;

import com.springboot.jap_demo.entity.EntityBean;
import com.springboot.jap_demo.entity.UserBean;

import java.util.List;

public interface UserService {

    UserBean findOne(String id);

    EntityBean findEntity(String id);

    List<EntityBean> findEntityById(String id);
}
