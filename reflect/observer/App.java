package com.newer.reflect.observer;

/**
 * Created by json on 2017/3/18.
 */
public class App {
    public static void main(String[] args) {

        //新建被观察者对象
        Data data=new Data();
        Other other=new Other();

        //新建界面对象
        Ui ui=new Ui();
        Cli cli=new Cli();

        //数据改变时会接收到变化  方法也会动态的执行  为数据添加观察者
        //数据的变化会去通知观察者
        data.addObserver(ui);
        //	other.addObserver(ui);
        //ui即是data的观察者 又是other的观察者  就像同时订阅了两个公众号

        //data.addObserver(cli);


        //调用的是数据的set方法  改变的是UI  观察者被调用  数据的订阅发布模式
        //
        data.setInfo(6);

        data.setInfo(8);

        data.setInfo(16);
    }

}
