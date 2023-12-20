/**
 * 
 */
let index ={
	init: function() {
//		document.getElementById("btn_save").addEventListener("click", save);
		$("#btn_save").on("click", () => {
			this.save();
		});
		$("#btn_delete").on("click", () => {
			this.deleteById();
		});
		$("#btn_update").on("click", () => {
			this.update();
		});
//		$("#btn_login").on("click", () => {
//			this.login();
//		});
	},
	
 	save: function() {
		
		let data = {
			title: document.getElementById("title").value,
			content: document.getElementById("content").value,
		};
		
		$.ajax({
			type:"POST"
			,url:"/api/board"
			,data:JSON.stringify(data)
			,contentType:"application/json; charset=UTF-8"
			,dataType:"json"
		}).done(function(res){
			alert("글쓰기가 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	deleteById: function() {
		let id = $("#id").text();
		
		$.ajax({
			type:"DELETE"
			,url:"/api/board/"+id
			,dataType:"json"
		}).done(function(res){
			alert("삭제가 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	update: function() {
		let id=$("#id").val();
		
		let data = {
			title: document.getElementById("title").value,
			content: document.getElementById("content").value,
		};
		
		$.ajax({
			type:"PUT"
			,url:"/api/board/"+ id
			,data:JSON.stringify(data)
			,contentType:"application/json; charset=UTF-8"
			,dataType:"json"
		}).done(function(res){
			alert("글수정이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
};

index.init();

