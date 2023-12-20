/**
 * 
 */
let index ={
	init: function() {
//		document.getElementById("btn_save").addEventListener("click", save);
		$("#btn_save").on("click", () => {
			this.save();
		});
//		$("#btn_login").on("click", () => {
//			this.login();
//		});
	},
	
 	save: function() {
		
		let data = {
			username: document.getElementById("username").value,
			password: document.getElementById("password").value,
			email: document.getElementById("email").value
			
		};
		
		//ajax가 통신을 성공후 json을 리턴해주면 자동으로 자바 오브젝트로 변환해준다
		$.ajax({
			type:"POST"
			,url:"/auth/joinProc"
			,data:JSON.stringify(data)
			,contentType:"application/json; charset=UTF-8"// body데이터가 어떤타입인지 (MIME)
			,dataType:"json"//응답결과를설정 기본적으로 모든것이 문자열 (만약 json이면 => jacascript Object로 변환해준다)
		}).done(function(res){
			alert("회원가입이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
//	login: function() {
//		
//		let data = {
//			username: document.getElementById("username").value,
//			password: document.getElementById("password").value,
//		};
//		
//		$.ajax({
//			type:"POST"
//			,url:"/api/user/login"
//			,data:JSON.stringify(data)
//			,contentType:"application/json; charset=UTF-8"// body데이터가 어떤타입인지 (MIME)
//			,dataType:"json"//응답결과를설정 기본적으로 모든것이 문자열 (만약 json이면 => jacascript Object로 변환해준다)
//		}).done(function(res){
//			alert("로그인이 완료되었습니다.");
//			location.href="/";
//		}).fail(function(error){
//			alert(JSON.stringify(error));
//		});
//	}
};

index.init();

