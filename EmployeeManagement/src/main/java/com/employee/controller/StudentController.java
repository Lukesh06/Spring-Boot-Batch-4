package com.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/hii/{name}")
	public String sayHi(@PathVariable String name) {
		return "Hiii "+name;
	}
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Student";
	}
	
	
	
}
