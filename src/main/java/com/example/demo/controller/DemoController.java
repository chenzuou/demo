package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping
	public void helloWorld(){
		System.out.println("HELLO WORLD");
	}
}
