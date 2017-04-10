package com.newer.reflect.Reflect;

import java.lang.reflect.Field;

public class BeanFactory {
	public static Object  getBean(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		//工厂  屏蔽了一些装配的过程
		
		//框架   屏蔽了一些复杂的过程  流程化自动化
		
		
		//传参数  帮你创建一个对象出来
		
		//加载类
		Class cl=Class.forName(className);
		
		//创建对象
		Object o=cl.newInstance();
		
		
		//填充对象的属性值
		int v=1;
		Field[] fds=cl.getFields();
		for (int i = 0; i < fds.length; i++) {
			Field  field=fds[i];
			 field.setInt(o,v++ );
			 //把一个值放到某个类型的一个字段上去
			}
			
 
		
		//传一个类的名字  根据类创建对象  得到对象里面所有的字段
		
		
		//重点：反射包里面  字段  方法  构造方法  打开文档看反射包里面的类和接口
		
		return o;
		
		
	}

}
