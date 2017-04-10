package com.newer.reflect.builder;

/**
 * 菜单（按钮）
 * Created by json on 2017/3/18.
 */
public class Bean {
    private  int size;
    private String a;
    private String b;
    private String c;
    public Bean(){

    }

    /***
     * 构造方法有局限性（只能识别参数类型，不能识别名称）
     * @param size
     * @param a
     */
    public Bean(int size,String a){
        super();
        this.size=size;
        this.a=a;
    }

    /**
     * 构造器
     * 目的：解决局限性
     * 方法：使用Builder()内部类替代外部类的构造方法
     *
     */
    public static class Builder{
        int size;
        String a;
        String b;
        String c;


        public Bean build() {
            //内部类可以访问外部类的的私有属性和方法

            Bean bean=new Bean();
            bean.size=size;
            bean.a=a;
            bean.b=b;
            bean.c=c;
            return bean;
        }

        public Builder setSize(int s) {
            this.size=s;
            return this;
        }
        public Builder setA(String a){
            this.a=a;
            return this;
        }

        public Builder SetB(String b) {
            this.b=b;
            return this;
        }

        public Builder setC(String c){
            this.c=c;
            return this;
        }
//        public Builder(int size,String a,String b,String c){
//            this.size=size;
//            this.a=a;
//            this.b=b;
//            this.c=c;
//        }
    }
}
