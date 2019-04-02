package com.springboot.jap_demo.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityUtils {

    public static final int INFO_LENGTH = 3;

    /**
     * @Description : 返回值转换为自定义类
     *
     * @Author : fengsx
     * @Date : 2019/4/2 14:57
     * @Param : [list, model, clazz]
     * @Return : java.util.List<T>
     *
     **/
    public static <T> List<T> castEntiry(List<Object[]> list, Object model, Class<T> clazz) {

        List<T> retList = new ArrayList<T>();

        if (list.isEmpty()) {
            return retList;
        }

        List<Map<String, Object>> filedsList = getFiledsInfo(model);
        int size = filedsList.size();
        for (Object[] obj : list) {
            if (obj.length != size) {
                System.out.println("属性个数错误");
                return retList;
            }
        }

        Class[] classes = new Class[size];
        for (int i = 0; i < size; i ++) {
            classes[i] = (Class) filedsList.get(i).get("type");
        }

        try {
            for (int i = 0; i < list.size(); i++) {
                Constructor<T> constructor = clazz.getConstructor(classes);
                T instance = constructor.newInstance(list.get(i));
                retList.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retList;

    }

    /**
     * @Description : 获得自定义类的返回值/名称/类型
     *
     * @Author : fengsx
     * @Date : 2019/4/2 14:55
     * @Param : [model]
     * @Return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     *
     **/
    public static List<Map<String, Object>> getFiledsInfo(Object model) {
        Field[] fields = model.getClass().getDeclaredFields();
        int length = fields.length;
        ArrayList<Map<String, Object>> list = new ArrayList<>(length);
        HashMap<String, Object> map = null;

        for (int i = 0; i < length; i++) {
            map = new HashMap<String, Object>(INFO_LENGTH);
            map.put("type", fields[i].getGenericType());
//            反射根据有参类型生成有参构造方法,下面代码不适用上下文
//            map.put("name", fields[i].getName());
//            map.put("value", getFiledValue(fields[i].getName(), model));
            list.add(map);
        }

        return list;
    }

    /**
     * @Description : 拼接构建方法,获得返回值
     *
     * @Author : fengsx
     * @Date : 2019/4/2 14:58
     * @Param : [name, model]
     * @Return : java.lang.Object
     *
     **/
    public static Object getFiledValue(String name, Object model) {
        try {
            String getStr = "get" + name.substring(0,1).toUpperCase() + name.substring(1);
            Method method = model.getClass().getMethod(getStr, new Class[]{});
            Object invoke = method.invoke(model);
            return invoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
