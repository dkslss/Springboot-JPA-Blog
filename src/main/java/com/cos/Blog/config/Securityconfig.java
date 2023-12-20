package com.cos.Blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.Blog.config.auth.PrincipalDetailService;


//빈 등록: 스프링 컨테이너에서 객체를 관리 할 수있게 하는 것
@Configuration
//@EnableWebSecurity // 시큐리티 필터가 등록된다. = 스프링 시큐리티가 활성화되어있는상태에서 어떤설정을 해당 파일에서 하겠다
//@EnableGlobalMethodSecurity(prePostEnabled= true) // 특정주소로 접근을 하면 권한 및 인증을 미리체크 하겠다는 뜻.
public class Securityconfig {
	
	

//	@Autowired
//	private PrincipalDetailService principalDetailService;

	@Bean // IoC가 된다  즉 리턴하는 값을 스프링이 관리
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	// 5. 기본 패스워드 체크가 BCryptPasswordEncoder 여서 설정 필요 없음.
	//시큐리티가 대신 로그인해주는데 password를 가로채기를하는데 
	// 해당 password가 뭘로 해쉬가 되어 회원가입이 되어있는지 알아야
	// 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수있음
	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
//	}
	
//	
	@Bean
    public AuthenticationManager authenticationManager(
    AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	 
	// 6. 최신 버전(2.7)으로 시큐리티 필터 변경
		@Bean
		SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			// 1. csrf 비활성화
			http.csrf().disable();

			// 2. 인증 주소 설정
			http.authorizeRequests(
					authorize -> authorize.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**", "/dummy/**").permitAll()
							.anyRequest().authenticated()
			);
			
			// 3. 로그인 처리 프로세스 설정
			http.formLogin(f -> f.loginPage("/auth/loginForm")
					.loginProcessingUrl("/auth/loginProc")
					.defaultSuccessUrl("/")
			);

			return http.build();
		}
}

//사라진 방식
////빈 등록: 스프링 컨테이너에서 객체를 관리 할 수있게 하는 것
//@Configuration
//@EnableWebSecurity// 시큐리티 필터 가 등록된다. = 스프링 시큐리티가 활성화되어있는상태에서 어떤설정을 해당 파일에서 하겠다
//@EnableGlobalMethodSecurity(prePostEnabled= true) // 특정주소로 접슨을 하면 권한 및 인증을 미리체크 하겠다는 뜻.
//public class Securityconfig extends WebSecurityConfigurerAdapter{
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		// 요청리퀘스트가 들어오면
//		http
//			.authorizeRequests()
//				.antMatchers("/auth/**")
//				.permitAll()
//				.anyRequest()// 이외의 주소 필터링
//				.authenticated();
//		
//	}
//}
