package com.cos.Blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ORM > 언어의 Object를 테이블로 만들어준다

@Entity // User 클래스가 자동으로 MySQL에 테이블이 생성된다
//@DynamicInsert //  insert시에  null을 제외
public class User {
	
	@Id // primary key
	//
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id;		// 시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;		// 아이디
	
	@Column(nullable = false, length = 100) // => 해쉬 암호화
	private String password; 
		
	@Column(nullable = false, length = 50) 
	private String email;
	
	/* Enum을 쓰면
	 * admin, user, manager  권한에따라 타입을 정해 규칙화하여 정형화코딩이 가능
	 */
//	@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋음 데이터의 도메인을 사용할수있다 
	
	
	@CreationTimestamp // 시간이 자동으로 입력됨
	private Timestamp createDate;
	
	
}
