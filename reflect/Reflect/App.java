package com.newer.reflect.Reflect;

public class App {
	public static void main(String[] args) {
		
		try {
			A a=(A) BeanFactory.getBean("Reflect.A");
			System.out.printf(a.hello("a"));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
