package com.cos.Blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempContollerTest {

	
	
	@GetMapping("temp/home")
	public String tempHome() {
		System.out.println("tempHome");
		return "home.html";
	}
	
	@GetMapping("temp/jsp") 
	public String tempJsp() {
		System.out.println("tempJsp");
		return "/test";
	}
}
