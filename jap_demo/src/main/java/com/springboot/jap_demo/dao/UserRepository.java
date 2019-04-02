package com.springboot.jap_demo.dao;

import com.springboot.jap_demo.entity.EntityBean;
import com.springboot.jap_demo.entity.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserBean,String> {

    /**
     * @Description : 测试实体类转换工具类
     *
     * @Author : fengsx
     * @Date : 2019/4/2 16:18
     * @Param : [id]
     * @Return : java.util.List<java.lang.Object[]>
     *
     **/
    @Query(
           value = "select a.userName,a.userPassword,b.name,b.nums from usertb a,demo b where a.userId = b.id and a.userId = :id"
    )
    List<Object[]> findEntiry(@Param("id") String id);

    /**
     * @Description : 测试指定路径+包名的返回自定义实体类查询
     *
     * @Author : fengsx
     * @Date : 2019/4/2 16:24
     * @Param : [id]
     * @Return : java.util.List<com.springboot.jap_demo.entity.EntityBean>
     *
     **/
    @Query(
            value = "select new com.springboot.jap_demo.entity.EntityBean(a.userName,a.userPassword,b.name,b.nums)" +
                    " from usertb a,demo b where a.userId = b.id and a.userId = :id"
    )
    List<EntityBean> findEntityById(@Param("id") String id);
}
