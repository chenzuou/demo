package com.example.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDemo {
	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger(1);
		new Thread(() ->{
			a.compareAndSet(1, 2019);
			System.out.println(Thread.currentThread().getName() + "---" + a.get());
		},"1").start();
		new Thread(() ->{
			a.compareAndSet(2, 99);
			System.out.println(Thread.currentThread().getName() + "---" + a.get());
		},"2").start();

		AtomicStampedReference<Integer> b = new AtomicStampedReference<>(1,1);
		new Thread(() -> {
			int version = b.getStamp();
			b.compareAndSet(1,99,2,version+1);
			System.out.println(Thread.currentThread().getName() + "---" + b.getReference());
		},"3").start();
		new Thread(() -> {
			int version = b.getStamp();
			b.compareAndSet(1,2018,1,version+1);
			System.out.println(Thread.currentThread().getName() + "---" + b.getReference());
		},"4").start();

		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "---" + SingleDemo.getDemo());
		},"5").start();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "---" + SingleDemo.getDemo());
		},"6").start();

		List<String> list1 = new Vector<>();
		List<String> list2 = Collections.synchronizedList(new ArrayList<>());
		List<String> list = new CopyOnWriteArrayList<>();

		Set<String> set1 = Collections.synchronizedSet(new HashSet<>());
		Set<String> set2 = new CopyOnWriteArraySet<>();

		Map<String,String> map1 = Collections.synchronizedMap(new HashMap<>());
		Map<String,String> map2 = new ConcurrentHashMap<>();

		ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		rwLock.readLock().lock();
		rwLock.readLock().unlock();
		rwLock.writeLock().lock();
		rwLock.writeLock().unlock();

	}

	//ReentrantLock(可重入)
	public boolean add(Object e){
		//非公平锁
		final ReentrantLock lock1 = new ReentrantLock();
		//公平锁
		final ReentrantLock lock2 = new ReentrantLock(true);
		lock1.lock();
		lock1.unlock();
		return true;
	}

}
