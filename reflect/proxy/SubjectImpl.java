package com.newer.reflect.proxy;

/**
 *
 * 主题（业务）的实现
 * Created by json on 2017/3/18.
 */
class SubjectImpl implements Subject {


    @Override
    public void sayBye(String msg) {
        //
        System.out.println("HELLO"+msg);
    }

    @Override
    public void sayHello(String msg) {

        System.out.println("BYE"+msg);
    }
}
