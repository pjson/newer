package com.newer.reflect.proxy_reflect;

import java.lang.reflect.Proxy;


/**
 * 观察者模型:
 * 使用代理   将比较繁琐的事情交给代理集中的处理  不管是哪个方法  都集中的处理
 * 反射的一个使用场景   动态代理
 * 用到的反射包里的类   Menthod   Proxy   可被调用的事务处理接口处理器
 */
public class APP {
	public static void main(String[] args) {

		Dao  r=new DaoImpl();
		//r是真实的对象
		//	r.save("data");

		//反射包里面的代理   创建一个新的代理对象
		//参数1：类加载器   参数2：接口   参数3：操作
		//日志的处理
		Dao dao=(Dao) Proxy.newProxyInstance(
				r.getClass().getClassLoader(),
				r.getClass().getInterfaces(),
				new TxHandler(r));
		//获得这个类然后获得类加载器     获得类然后获得这个类实现的接口  日志处理操作
		//找到这个类里面接口中所有的方法
		//动态的调用一个方法  这个方法不需要自己去执行

		dao.save("qiuqiu");

		String  msg=dao.load(6);
		System.out.println(msg);

		dao.remove(8);


	}
}
