<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
  
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="content d-flex justify-content-center">
			<div class="join-box my-5">
				<div class="display-4">회원가입</div>
				<!-- 아이디, 패스워드, 패스워드 확인, 이름, 이메일 -->
				<input type="text" class="form-control mt-3" placeholder="아이디" id="loginIdInput">
				<input type="password" class="form-control mt-3" placeholder="비밀번호" id="passwordInput">
				<input type="password" class="form-control mt-3" placeholder="비밀번호 확인" id="passwordConfirmInput">
				<input type="text" class="form-control mt-3" placeholder="이름" id="nameInput">
				<input type="text" class="form-control mt-3" placeholder="이메일" id="emailInput">
				
				<button type="button" id="joinBtn" class="btn btn-info btn-block mt-3">회원가입</button>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			$("#joinBtn").on("click", function() {
				var loginId = $("#loginIdInput").val();
				var password = $("#passwordInput").val();
				var passwordConfirm = $("#passwordConfirmInput").val();
				var name = $("#nameInput").val();
				var email = $("#emailInput").val();
				
				if(loginId == "") {
					alert("아이디를 입력하세요");
					return;
				}
				
				if(password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}
				
				if(password != passwordConfirm) {
					alert("비밀번호가 틀립니다");
					return;
				}
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/user/sign_up",
					data:{"loginId":loginId, "password":password, "name":name, "email":email},
					success:function(data) {
						if(data.result == "success") {
							// 로그인 화면으로 이동
							location.href = "/user/signup_view";
						} else {
							alert("회원가입 실패");
						}
					},
					error:function() {
						alert("에러 발생");
					}
				});
			});
 		});
	</script>
</body>
</html>