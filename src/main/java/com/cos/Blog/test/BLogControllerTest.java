package com.cos.Blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 스프링이 com.cos.blog 패키지 이하를 스캔해서 특정어노태이션이 붙어있는 
			// 클래스파일들을 IOC 해서 스프링컨테이너에 관리를해준다
public class BLogControllerTest {
	
	//http://localhost8080/test/hello
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello spring boot</h1>";
	} 
}

