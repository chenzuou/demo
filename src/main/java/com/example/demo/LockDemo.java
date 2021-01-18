package com.example.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
//轮流加减1
public class LockDemo {
	public static void main(String[] args) {
		Deal deal = new Deal();
		new Thread(() -> {
			for(int i=0;i<5;i++){
				deal.add();
			}
		},"AAA").start();
		new Thread(() -> {
			for(int i=0;i<5;i++){
				deal.dec();
			}
		},"BBB").start();
	}
}

class Deal{
	private ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	int num = 0;
	public void add() {
		lock.lock();
		try{
			while(num != 0){
				condition.await();
			}
			num++;
			System.out.println(Thread.currentThread().getName() + num);
			condition.signalAll();
		}catch (InterruptedException e){
		}finally {
			lock.unlock();
		}
	}

	public void dec() {
		lock.lock();
		try{
			while(num == 0){
				condition.await();
			}
			num--;
			System.out.println(Thread.currentThread().getName() + num);
			condition.signalAll();
		}catch (InterruptedException e){
		}finally {
			lock.unlock();
		}
	}
}
