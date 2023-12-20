<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">

	
	<form>
		<div class="form-group">
			<label for="username">title</label> 
			<input type="text" class="form-control" placeholder="Enter username" id="title">
		</div>
				
		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control summernote" rows="5" id="content" name="text"></textarea>
		</div>
	</form>
	
	<button id="btn_save" class="btn btn-primary">글쓰기완료</button>
	
</div>

<script>
  $('.summernote').summernote({
    placeholder: 'Comment..',
    tabsize: 2,
    height: 300
  });
</script>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>