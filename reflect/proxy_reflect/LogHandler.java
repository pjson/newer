package com.newer.reflect.proxy_reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by json on 2017/3/18.
 */
public class LogHandler implements InvocationHandler {
    //调用的处理器
    Dao dao=null;

    public LogHandler(Dao dao){
        this.dao=dao;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("前置操作");

        //方法被调用   被调用时哪一个对象   方法的参数
        //通过方法名可以调用方法
        Object r=method.invoke(dao, args);
        //方法可以代表任何一个方法

        System.out.println("后置操作");
        return r;
    }
}
