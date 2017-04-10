package com.newer.reflect.proxy;

/**
 *  AOP     （Aspect 织入横切面
 *  代理者（代替实现类）
 * 定义：代理对象没有实现sayHello
 *      是用的Subject里面的sayHello
 * 创建代理（一个中间人 ）
 * 功能：
 * Created by json on 2017/3/18.
 */
//代理对象没有实现sayHello   是用的Subject里面的sayHello
//代理自己并没有实现   但他可以在真实实现的前后做一些事情
public class SubjectProxy implements Subject {

    //真实实现
    private Subject subject=null;

    public SubjectProxy(){
        super();
    }
    /**
     * 构造方法（传入一个subject参数)
     *         而不是new一个，不然就变成山寨了）
     * @param subject
     */
    public SubjectProxy(Subject subject){
        this.subject=subject;
    }

    @Override
    public void sayHello(String msg) {
        System.out.println("前置拦截");
        String m=msg.toUpperCase();
        subject.sayHello(m);
        System.out.println("后置拦截");
    }

    @Override
    public void sayBye(String msg) {
        System.out.println("前置拦截");
        String m=msg.toUpperCase();
        subject.sayBye(msg);
        System.out.println("后置拦截");
    }
}
