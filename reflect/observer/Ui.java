package com.newer.reflect.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者用户界面
 * Created by json on 2017/3/18.
 */
public class Ui implements Observer {//界面实现观察者接口
    @Override
    public void update(Observable o, Object arg) {//重写更新方法

        //Class clazz=o.getClass
        //得到这个对象的类型

        //第一个参数是被观察对象 ，可以得到被观察对象的的状态
        if(o instanceof Data){
            //先验证o是Data的类型
            Data data=(Data)o;//然后做强转

            int info=data.getInfo();
            System.out.println("ui 显示"+info);
        }
        System.out.println("ui updata"+arg);

    }

}
