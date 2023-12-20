package com.cos.Blog.sevice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Blog.model.RoleType;
import com.cos.Blog.model.User;
import com.cos.Blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을해준다 , IOC
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void signUp(User user) {
		try {
			
			String rawPassword = user.getPassword(); // 1234 원문
			String encPassword = encoder.encode(rawPassword); // 해쉬
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() :" + e.getMessage());
		}
	}

	
//	@Transactional(readOnly = true)// select할때 트랜잭션시작, 서비스종료시에 트랜잭션 종료 (정합성)
//	public User signIn(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
	
}
