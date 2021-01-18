package com.example.demo;

public class SingleDemo {
	private static volatile SingleDemo demo = null;
	public static SingleDemo getDemo(){
		if(demo == null){
			synchronized (SingleDemo.class){
				if(demo == null){
					demo = new SingleDemo();
				}
			}
		}
		return demo;
	}
}
