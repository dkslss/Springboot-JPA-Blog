package com.cos.Blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.Blog.model.User;

//DAO
// 자동으로 Bean 등록이 된다 
// @Repository  // 생략이 가능하다
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//select * from user where username = 1?
	Optional<User> findByUsername(String username);
}



//JPA Naming 쿼리 전략
	// SELECT * FROM user WHERE username =?1 AND password=?2;
	// User findByUsernameAndPassword(String username, String password);
	
//	@Query(value="SELECT * FROM user WHERE username =? AND password=?;", nativeQuery= true)
//	User login(String username, String password);