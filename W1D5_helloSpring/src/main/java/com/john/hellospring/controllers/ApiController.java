package com.john.hellospring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class ApiController {

	@RequestMapping("/")
	public String home() {
		return "hello ninjas from Spring!";
	}
	
	@RequestMapping("/cool")
	public String coolRoute() {
		System.out.println("hey look! we are cool!");
		return "<h2>we are in the cool route</h2> <p>hello</p>";
	}
	
//	=== QUERY PARAMETERS ===
	@RequestMapping("/search")
//	localhost:8080/search?q=some search text
	public String searchSomething(@RequestParam(value="q") String someSearchVar) {
		System.out.println("you searched for " + someSearchVar);
		return "you searched for " + someSearchVar;
	}
	
//	=== PATH VARIABLES ===
	@RequestMapping("/find/{age}/{nameVar}")
	public String findSomething(@PathVariable("nameVar") String name,
								@PathVariable("age") int age) { 
		System.out.println(name);
		if(age >= 21) {
			return "Congrats " + name + " you are ready to pass!";
		} else {
			return "soory " + name + " you shall not pass";
		}
	}
	
	
	
	
	
}
