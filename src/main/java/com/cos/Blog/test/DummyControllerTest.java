package com.cos.Blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Blog.model.RoleType;
import com.cos.Blog.model.User;
import com.cos.Blog.repository.UserRepository;
// html파일이 아니라 데이터를 리턴해주는 Controller = @RestController
@RestController
public class DummyControllerTest {


	
	@Autowired
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당id는 DB에 없습니다.";
		} 
		
		return "삭제되었습니다. id" + id;
	}
	
	// save 함수는 id를 전달하지 않으면 insert를해주고
	// save 함수는 id를 전달하면 해당 id에대한 데이터가 있으면 update를 해주고
	// save 함수는 id를 전달하면 해당 id에대한 데이터가 없으면 insert를한다.
	//email, password
	@Transactional// 함수 종료시에 자동 커밋된다.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {// json 데이터를 요청 -> Java Object(MessageConverter의 Jackson 라이브러리가 변환해서 받아준다)
		System.out.println("id : " + id);
		System.out.println("password : " + requestUser.getPassword());
		System.out.println("email : " + requestUser.getEmail());
		
		// 영속화된 데이터
		// 실제데이터름담는다.
		User user = userRepository.findById(id).orElseThrow(()-> {
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		// 1차캐시에서 영속화된데이터를 변경
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		// 만약에 변경된데이터가없다면 아무런일도안일어남
		// 즉 변경을 감지해준다 == 더티체킹
//		userRepository.save(user);
		
		//더티 체킹
		
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
	//한페이지당 2건에 데이터를 리턴받아 볼 예정
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2,sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users =pagingUser.getContent();
		return users;
	}
	
	
	//{id} 주소로 파라미터를 받을수 있음
	//http://localhost:8000/Blog/dummy/user/2
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4을 찾으면 내가 데이터베이스에서 못찾아오게되면 user가 null이 될 것이 아닌가 
		// return할때 null 이면 문제가 생긴다
		//Optional로 너의 User객체를 감싸서 가져올테니  null인지 아닌지 판단후 return
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return  new IllegalArgumentException("해당유저는 없습니다 id :" + id);
			}
		});
//		람다식
//		User  user = userRepository.findById(id).orElseThrow(()-> {
//			return new IllegalArgumentException("해당유저는 없습니다");
//		});
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				// TODO Auto-generated method stub
//				return  new User();
//			}
//			
//		});
		
		
		// 요청 : 웹 브라우저
		// 자바 오브젝트 -> json(gson) == 기존
		// 스프링부트 = MessageConverter가 자동 작동
		// 만약 자바 오브젝트를 리턴하면 MessageConverter가 Jackson 라이브러리를 호출
		// user 오브젝트를 json으로 변환해서 브라우저에게 던짐
		return user;
	}
	
	
	//http:\\localhost:8000/blog/dummy/join(요청)
	//http의 body에 username, password, email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username :" + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email :" + user.getEmail());
		
		user.setRole(RoleType.USER);
		
		userRepository.save(user);
		return "회원가입이 완료되었습니다";
	}
}
