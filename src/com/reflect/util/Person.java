package com.reflect.util;

import java.util.Map;

public class Person {
	private int age;
	public String name;
	
	public Person(String name){
		this.name=name;
	}
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}

	public void foo(Map<String,Object> string){
		System.out.print("hello world!");
	}
	
	public static void say(String name,int age){
		System.out.println("say");
	}
	
	private static void run(){
		System.out.println("run");
	}
	
}
