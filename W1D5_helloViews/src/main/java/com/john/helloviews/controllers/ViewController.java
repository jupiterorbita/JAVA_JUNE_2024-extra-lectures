package com.john.helloviews.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("name", "<h1>John</h1><script>alert('you have been hacked')</script>");
		model.addAttribute("age", 38);
		return "index.jsp";
	}
	
	@GetMapping("/cool")
	public String coolPage(Model model) {
		ArrayList<String> names = new ArrayList<String>(); // []
		names.add("Seth");
		names.add("Yoni");
		names.add("Srujan"); // ["Seth", "Yoni", "Srujan"]
		
		model.addAttribute("names", names);
		
		model.addAttribute("number", 7);
		return "cool.jsp";
	}
	
	
	
	
	
	
	
	
}
