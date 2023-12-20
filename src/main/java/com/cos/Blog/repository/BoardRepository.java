package com.cos.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.Blog.model.Board;
public interface BoardRepository extends JpaRepository<Board, Integer>{
}