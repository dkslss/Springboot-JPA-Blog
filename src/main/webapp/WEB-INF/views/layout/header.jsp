<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<html lang="en">
<head>
	<title>Cos</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
    
    
	
</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	  <a class="navbar-brand" href="/">
		<svg width="60px" height="83px" viewBox="0 0 235 83" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
		    <title>FINAL_Logo_RGB</title><defs><polygon id="path-1" points="0 0.005 234.44 0.005 234.44 82.94 0 82.94"></polygon>
		    </defs><g id="FINAL_Logo_RGB" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><mask id="mask-2" fill="white"><use xlink:href="#path-1"></use></mask><g id="Clip-2"></g><path d="M184.288,62.013 L176.346,71.261 C183.696,79.323 194.129,83 205.036,83 C220.45,83 234.44,73.394 234.44,58.813 C234.44,31.542 190.097,38.539 190.097,21.821 C190.097,15.062 196.738,11.862 205.154,11.862 C212.152,11.862 219.029,15.062 223.771,18.739 L230.053,9.015 C222.941,3.207 214.048,0.005 204.919,0.005 C191.639,0.005 178.004,7.829 178.004,22.056 C178.004,49.328 222.347,42.451 222.347,58.813 C222.347,67.347 213.692,71.142 205.036,71.142 C197.212,71.142 188.913,66.638 184.288,62.013" id="Fill-1" fill="#1B1B1B" mask="url(#mask-2)"></path><path d="M123.666,71.142 C139.79,71.142 152.951,57.389 152.951,41.502 C152.951,25.496 139.79,11.86 123.666,11.86 C107.543,11.86 94.143,25.496 94.143,41.502 C94.143,57.389 107.543,71.142 123.666,71.142 M123.549,0.005 C146.549,0.005 165.045,18.619 165.045,41.502 C165.045,64.384 146.549,83 123.549,83 C100.666,83 82.049,64.384 82.049,41.502 C82.049,18.619 100.666,0.005 123.549,0.005" id="Fill-3" fill="#1B1B1B" mask="url(#mask-2)"></path><path d="M72.916,13.877 C65.327,5.221 54.184,0.005 41.496,0.005 C18.496,0.005 0,18.381 0,41.502 C0,64.622 18.496,82.998 41.496,82.998 C54.42,82.998 65.683,77.546 73.272,68.77 L64.143,60.946 C58.806,67.23 50.746,71.142 41.496,71.142 C25.491,71.142 12.093,57.508 12.093,41.502 C12.093,25.496 25.491,11.86 41.496,11.86 C50.746,11.86 58.57,15.892 64.143,22.176 L72.916,13.877" id="Fill-4" fill="#1B1B1B" mask="url(#mask-2)"></path></g>
		</svg>
	  </a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	  
		<c:choose>
			<c:when test="${empty principal}">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/board/saveForm">글쓰기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
    	
	  </div>  
	</nav>
	<br/>