package com.in28minutes.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
}
