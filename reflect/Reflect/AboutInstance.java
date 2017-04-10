package com.newer.reflect.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 实例的反射  实例即对象
public class AboutInstance {
	public static void main(String[] args) {
		//1 bean factory
		Class cl=C.class;

		try {
			//间接的调用了类的构造方法
			//如果C中没有默认的无参构造方法  就不能通过反射创建c
			//通过cl创建一个对象
			Object o=cl.newInstance();

			//得到一个叫bye带一个参数的方法
			//方法在对象上调用  传一个参数进去
			Method m=cl.getDeclaredMethod("bye", String.class);

			String msg=(String) m.invoke(o, "反射");  //调用o中的bye方法   参数是“反射”
		 	System.out.println(msg);
		
		
			System.out.println(o.getClass().getName());
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 

}
