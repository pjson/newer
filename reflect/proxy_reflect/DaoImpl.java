package com.newer.reflect.proxy_reflect;

/**
 * Created by json on 2017/3/18.
 */
public class DaoImpl implements Dao {
    int conn;//次数

    public void setConn(int conn){
        this.conn=conn;
    }

    /*
    DataSource ds;

    public void setDataSource(DataSource ds){
        //设置数据源

        this.ds=ds;



    }
    */
    @Override
    public void save(String msg) {
        System.out.println(conn+"SAVE"+msg);
        //数据源获得连接   执行操作
    }
    //这个方法我不去调用  让反射去调用
    @Override
    public String load(int id) {
        String msg="data"+id;
        return conn+"data"+id;
    }

    @Override
    public void remove(int id) {
        System.out.println(conn+"remove"+id);
    }

}
