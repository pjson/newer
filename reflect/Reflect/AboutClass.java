package com.newer.reflect.Reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import java.lang.reflect.Method;
 

public class AboutClass {

	//传了一个对象进来  得到它的一些属性
	public static void foo(A o){
		
		//获得对象o的类型
		Class cl2=o.getClass();
		Class cl3=A.class;
//		class cl4=Class.forName(o);
		
		System.out.println(cl2.getSimpleName() );
		
		//属性
		//java bean
		// 1.字段  public  2.无参构造方法     3.给属性加上get  set 方法
		Field[]  fs=cl2.getDeclaredFields();  //得到声明了的字段
		for (Field f : fs) {//遍历字段数组
			System.out.printf("%s %s\n",f.getType(),f.getName());
		}
		
		//通过反射  可以间接的调用对象的方法
		System.out.println(fs.length);

		//方法
//		Method[] ma1=cl2.getMethods();
		Method[] ms=cl2.getDeclaredMethods();
		System.out.println(ms.length);
		for (Method m : ms) {
			//获得每一个已声明方法的返回类型  方法名 和参数类型的长度
			System.out.printf("%s %s(%d) \n",
					m.getReturnType(),   
					m.getName(),
					m.getParameterTypes().length);
			
		}

		//注解
		Annotation[] annos=cl2.getAnnotations();
		System.out.println(annos.length);
		for (Annotation annotation : annos) {
			System.out.printf("     ",
					annotation.annotationType().getName());
			//得到注解的类型 注解的名字
			//RunTime运行时是反射可以读取的
			
			//$美元符号一般是内部类型
			
		}
		
	}
   public static void main(String[] args) {
	   
	Class cl=Date.class;
	System.out.println(cl.getPackage());
	System.out.println(cl.getName());
	System.out.println(cl.getSimpleName());
	
	
	foo(new A());
	foo(new B());
	foo(new C());
}
   
    
   
   
   

}
