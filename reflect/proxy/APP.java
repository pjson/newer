package com.newer.reflect.proxy;

/**
 * Created by json on 2017/3/18.
 */
public class APP {

    public void todo(Subject subject,String msg){
        subject.sayHello(msg);

        subject.sayBye(msg);
    }
    public static void main(String[] args) {
        APP app=new APP();


        //不同的方面：解耦（高内聚，低耦合）
        //模块内：高内聚（恰好做好一件事）
        //模块外：低耦合（模块间的接口尽可能少）
        Subject s=new SubjectImpl();
        System.out.println("---------------1");
        app.todo(s,"2017");

        System.out.println("---------------2");
        app.todo(new SubjectProxy(s),"2017");

        System.out.println("---------------3");
        app.todo(new SubjectProxyOther(s),"2017");

//        不能显现实现类的功能
//        Subject s=new SubjectImpl();
//        s.sayBye("2017");



        //使用代理类实现接口
   /*     new SubjectProxy().sayBye("2017");*/
//        new SubjectProxy(new SubjectImpl()).sayHello("2017");




//        Subject s;
//        //用实现类
//        s=new SubjectImpl();
//        s.sayBye("abc");
//        //用代理类
//        s=new SubjectProxy(new SubjectImpl());
//        s.sayBye("abc");
//        //用代理类
//        s=new SubjectProxyOther(new SubjectImpl());
//        s.sayBye("abc");
//        //使用二级代理
//        s=new SubjectProxyOther(
//                new SubjectProxy(
//                        new SubjectImpl()));
//        s.sayBye("abc");





    }
}
