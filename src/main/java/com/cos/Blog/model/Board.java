package com.cos.Blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이됨
	
	private int count; //조회수
	
	@ManyToOne(fetch=FetchType.EAGER) // Many = Many , User = one
	@JoinColumn(name="userId") // 어떤유저가썼는지
	private User user; //DB는 오브젝트를 저장할수없어서 FK를 사용 , JAVA는 오브젝트를 저장할수있다
	
	///꼭필요한경우 EAGER 아닌경우 LAZY
	@OneToMany(mappedBy="board",fetch=FetchType.EAGER)// 연관관계의 주인이 아니다 DB에 컬럼을 만들지 말라
	private List<Reply> reply;
	
	
	@CreationTimestamp
	private Timestamp createDate;
}
