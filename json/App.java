package com.newer.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	public static void main(String[] args) {

		Person p1 = new Person("john", "smith", "male", 21);
		p1.setAddress(new Address("cs", "shaoshan"));
		
		Gson gson = new Gson();
		// 对象 --> JSON 序列化
		String data = gson.toJson(p1);
		
//		System.out.println(data);
		
		// JSON --> 对象 反序列化
		Person p2 = gson.fromJson(data, Person.class);

//		System.out.println(p2.toString());

		Gson gson2 = new GsonBuilder()
				.disableHtmlEscaping()
				.disableInnerClassSerialization()
				.enableComplexMapKeySerialization()
				.generateNonExecutableJson()
				.create();
		String data1 = gson2.toJson(p1);
		System.out.println(data1);
	}

}
