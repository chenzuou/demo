package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping
	public String helloWorld(){
		String name = "HELLO WORLD";
		System.out.println(name);
		return name;
	}
}
