package com.cos.Blog.Controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Blog.dto.ResponseDTO;
import com.cos.Blog.model.User;
import com.cos.Blog.sevice.UserService;

// 데이터만 리턴해준다
@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	//회원가입 
	@PostMapping("/auth/joinProc")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController: save 호출됨");
		userService.signUp(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(),1);// 자바오브젝트를 json으로 변환해서 리턴 (jackson)
	}
	
	
	//스프링 시큐리티 이용해서 로그인
	
	
	
	
	//전통방식 로그인
//	@PostMapping("/api/user/login")
//	public ResponseDTO<Integer> login(@RequestBody User user, HttpSession session) {
//		System.out.println("UserApiController: login 호출됨");
//		User principal = userService.signIn(user);
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDTO<Integer>(HttpStatus.OK.value(),1);
//	}
}
