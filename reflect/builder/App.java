package com.newer.reflect.builder;

/**
 * Created by json on 2017/3/18.
 */
public class App {
    public static void main(String[] args) {



        //如果是非静态的要用外部类的对象声明内部类的对象
//        Bean b1=new Bean();
//        b1.Builder builder=new b1.Builder();

        //如果内部类是静态的
//         Bean b=new Bean.Builder().build();

        Bean b=new Bean.Builder()
                .setSize(9)//构造方法中参数1           可选参数
//                .setA("a")//构造方法中参数2            可选
                .SetB("b")//构造方法中参数3            可选
                .setC("c")//构造方法中参数4            可选
                .build();//工厂加工生产成构造方法
        System.out.println(b);

//        Bean b1=new Bean.Builder(9,"a","b","c").build();
    }
}
