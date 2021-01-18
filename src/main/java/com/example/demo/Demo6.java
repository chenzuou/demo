package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo6 {
	public static void main(String[] args) {
//		A a1 = new A("第1本","书籍");
//		A a2 = new A("第2本","书籍");
//		A a3 = new A("第1瓶","可乐");
//		A a4 = new A("第2瓶","可乐");
//		List<A> list = new ArrayList<>();
//		Collections.addAll(list,a1,a2,a3,a4);
//
////		List<String> typeList = list.stream().map(A::getType).collect(Collectors.toList());
////		typeList.forEach(item -> System.out.println(item));
//
//		Map<String,List<A>> groupList = list.stream().collect(Collectors.groupingBy(A::getType));
//		groupList.forEach((key, value) -> value.forEach(item -> System.out.println(key + ":" + item)));

		List<Integer> list = Stream.iterate(0,n -> n+1).limit(10).collect(Collectors.toList());
		list.forEach(item -> System.out.println(item));

		Optional.ofNullable(list).orElse(null);
	}

}

class A{
	private String name;
	private String type;

	@Override
	public String toString() {
		return "A{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}

	public A(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
