package com.newer.reflect.proxy_reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//重点：在原有方法的调用过程中
//根据需要插入我们所需要的代码
//通过代理层加入新的功能

public class TxHandler implements InvocationHandler{
	//必须实现可被调用的事务处理接口
	Dao dao;

	//构造方法
	public TxHandler(Dao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		int conn=DataSource.getInstance().getConnection();
		System.out.println("建立连接，获得资源"+conn);
		
		//通过set方法将数据源传过去
		Method set=	dao.getClass().getMethod("setConn",Integer.TYPE);
		
		//方法的名字  方法的参数类型  在dao上面调用

		//每次都是全新的数据源     每次调用dao都是全新的
		//单例模式  保证一个东西只有一份

		set.invoke(dao,conn);  //通过类名调用获得实例静态方法
		//真正的被代理对象的方法调用
		Object r=method.invoke(dao, args);
		
		System.out.println("释放资源  关闭连接"+conn);
		return r;
	}

}
