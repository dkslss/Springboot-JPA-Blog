package com.cos.Blog.Controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.Blog.config.auth.PrincipalDetail;
import com.cos.Blog.dto.ResponseDTO;
import com.cos.Blog.model.Board;
import com.cos.Blog.sevice.BoardService;

// 데이터만 리턴해준다
@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDTO<Integer> save(@RequestBody Board board,  @AuthenticationPrincipal PrincipalDetail principal) {
		//principal 세션같은역할
		boardService.writing(board, principal.getUser());	
		return new ResponseDTO<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDTO<Integer> deleteById(@PathVariable int id) {
		boardService.deleteByIdArticle(id);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(),1);
	}
	//스프링 시큐리티 이용해서 로그인
	
	
	@PutMapping("api/board/{id}")
	public ResponseDTO<Integer> update(@PathVariable int id, @RequestBody Board board) {
		boardService.articleUdateById(id,board);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}

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
