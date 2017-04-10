package com.newer.reflect.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者命令行接口
 * User Interface
 * Created by json on 2017/3/18.
 */
public class Cli implements Observer {
    //cli 命令行接口界面
    @Override
    public void update(Observable o, Object arg) {

        System.out.println("cli update"+arg);
    }
}
