package com.newer.reflect.proxy;

/**
 * Created by json on 2017/3/18.
 */
public class SubjectProxyOther implements Subject {

    private Subject subject;

    public SubjectProxyOther(Subject subject){
        super();
        this.subject=subject;
    }
    @Override
    public void sayHello(String msg) {
        System.out.println("前置安全");
        subject.sayHello(msg);
        System.out.println("后置安全处理");
    }

    @Override
    public void sayBye(String msg) {
        System.out.println("前置安全");
        subject.sayBye(msg);
        System.out.println("后置安全处理");
    }
}
