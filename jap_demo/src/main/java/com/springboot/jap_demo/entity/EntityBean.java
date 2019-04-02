package com.springboot.jap_demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class EntityBean implements Serializable {

    private String userName;
    private String userPassword;
    private String name;
    private Integer nums;

    public EntityBean() {
    }

    public EntityBean(String userName, String userPassword, String name, Integer nums) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.name = name;
        this.nums = nums;
    }

    @Id
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "EntityBean{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", name='" + name + '\'' +
                ", nums='" + nums + '\'' +
                '}';
    }
}
