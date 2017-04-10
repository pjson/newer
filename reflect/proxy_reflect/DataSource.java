package com.newer.reflect.proxy_reflect;

public class DataSource {
	static int i=1;  //声明一个静态的计数器
	private static DataSource instance=new DataSource();
	
	private int id;
	
	//获得连接   对象存在才会获得连接
	public int getConnection(){
		
		return  id++;
		
		
	}
	
	
	private DataSource(){//构造方法是私有的
		                   //提供一个静态的方法   
		                   //在内部使用构造方法创建一个实例
		id=1;
		
		
	}
	
	
	public static DataSource getInstance(){
		
		return instance;
		
	}

}
