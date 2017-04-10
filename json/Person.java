package com.newer.json;

import com.google.gson.annotations.SerializedName;

public class Person {

	@SerializedName(value = "fn")
	private String firstName;

	@SerializedName(value = "ln")
	private String lastName;

	private String sex;
	private int age;

	private Address address;

	public Person() {
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person(String firstName, String lastName, String sex, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [" + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "") + (sex != null ? "sex=" + sex + ", " : "")
				+ "age=" + age + "]";
	}

}
