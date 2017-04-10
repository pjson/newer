package com.newer.reflect.Reflect;

 class A {

	public int a;
	int d;
	
	public String hello(String name){
		
		System.out.println("hello"+name);
		return name;
		
	}
	 
}

 
 @Root
 class B extends A{
	@Element
	public int b;
 }
 
 class C extends B{
	 public C(){
		 
		 
	 }
	 
	public int c;
	
	public String bye(String n){
		
	 
		return n;
	}
 }