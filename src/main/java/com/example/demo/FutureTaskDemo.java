package com.example.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
	public static void main(String[] args) {
		FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
		new Thread(futureTask, "AA").start();
		new Thread(futureTask, "BB").start();

	}

}

//多线程中，第3种获得多线程的方式
class MyThread implements Callable<Integer> {
	@Override
	public Integer call() throws Exception{
		return 1024;
	}
}