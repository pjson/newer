package com.newer.reflect.Reflect;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//在运行时都可见
@Retention(value = RetentionPolicy.RUNTIME)

@Target(value = { ElementType.TYPE })
// 设置元素目标为类型type TYPE, //接口、类、枚举、注解
public @interface Root {

	// 指定别名
	String name() default "";

}
