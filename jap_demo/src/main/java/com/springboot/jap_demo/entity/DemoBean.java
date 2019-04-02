package com.springboot.jap_demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "demo")
@Table(name = "DEMO")
public class DemoBean implements Serializable {

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "nums")
    private Integer nums;

    public DemoBean() {
    }

    public DemoBean(Integer id, String name, Integer nums) {
        this.id = id;
        this.name = name;
        this.nums = nums;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
