package com.newer.reflect.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 *
 * 被观察者
 * Created by json on 2017/3/18.
 */
//数据被观察  被监听
//被观察者继承Observable类
public class Data extends Observable{//工具包里面有一个可被观察的类
    //类和接口  最本质的区别是类里面有一些已经实现的方法
    //数据是一个可以被观察的对象
    //可以往里面添加观察者
    //当状态改变时  通知观察者

    private int info;

    //修改info的值  设置info
    public void setInfo(int info) {
        this.info = info;

        //发生改变    通知观察者
        setChanged();  //设置改变
        //	notifyObservers();  //通知所有观察者  不带参数的通知


        notifyObservers(info); //带参数的通知
        //参数是public void update(Observable o, Object arg)更新方法里面的arg

    }

    public int getInfo() {
        return info;
    }



}
