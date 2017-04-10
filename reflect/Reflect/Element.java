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

//加大括号表示一个数组，指被修饰的注解能用于多个不同的类成员。
//表示注解A能用来修饰类中的Field(属性）和Method（方法）
@Target(value = { ElementType.FIELD, ElementType.TYPE })
public @interface Element {

	String name() default "";

}