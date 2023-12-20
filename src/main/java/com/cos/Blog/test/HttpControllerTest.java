package com.cos.Blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest:";
	
	//localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		
		Member m = Member.builder().userName("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG + "getter : " + m.getId());
		m.setId(5000);
		System.out.println(TAG + "getter : " + m.getId());
		return "test 완";
		}
	
	//http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		
		
		return "get 요청";
	}
	
	//http://localhost:8080/http/post
	@GetMapping("/http/post")
	public String postTest() {
		return "post 요청";
	}
	
	//http://localhost:8080/http/put
	@GetMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	
	//http://localhost:8080/http/delete
	@GetMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}
