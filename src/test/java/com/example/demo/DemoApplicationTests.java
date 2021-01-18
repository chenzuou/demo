package com.example.demo;

import com.example.demo.controller.HelloSender;
import com.example.demo.controller.TopicSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	TopicSender sebder;

	@Test
	public void contextLoads() {
//		sebder.send1();

		sebder.send2();
	}

}
