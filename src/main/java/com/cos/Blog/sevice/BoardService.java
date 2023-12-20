package com.cos.Blog.sevice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.Blog.model.Board;
import com.cos.Blog.model.User;
import com.cos.Blog.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@Transactional
	public void writing(Board board, User user) {// title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

	@Transactional(readOnly=true)
	public Page<Board> articleList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}

	

	public Board detailsAritcle(int id) {
		return boardRepository.findById(id)
				.orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을수 없습니다.");
		});

	}

	@Transactional
	public void deleteByIdArticle(int id) {
		boardRepository.deleteById(id);
	}

	@Transactional
	public void articleUdateById(int id, Board requestBoard) {
		// 영속화
		Board board = boardRepository.findById(id)
				.orElseThrow(() -> {
					return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을수 없습니다.");
				});// 영속화
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		//해당함수 종료시(Service가 종료될때) 트랜잭션이 종료된다, 이때 더티체킹 - 자동 업데이트가 됨 DB fluch
	}

}
