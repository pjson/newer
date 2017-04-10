package com.newer.reflect.proxy_reflect;

/**
 * 数据访问操作
 * Created by json on 2017/3/18.
 */
//动态代理：基于接口中方法的代理
//定义的具体操作
//主题    接口  数据访问操作
public interface Dao {
    /**
     *保存信息
     * @param msg
     */
    void save(String msg);

    /**
     * 根据主键加载信息
     * @param id
     * @return
     */
    String load(int id);

    void remove(int id);
}
