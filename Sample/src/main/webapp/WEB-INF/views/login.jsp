<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="text" id="userId" placeholder="아이디" required /><br><br>
		<input type="password" id="userPw" placeholder="비밀번호" /><br><br>
		<input type="button" id="btn_login" value="로그인" />
	</form>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    	$(function(){
    		bind();
    	});
    	
    	function bind(){
    		
    		$("#btn_login").off("click").on("click", function(){
    			
    			let id = $("#userId").val();
    			let pw = $("#userPw").val();
    			
    			let data = {
    					user_id : id,
    					user_pw : pw
    			}
    		
    		let url = "http://localhost:8080/loginCheck";
    			
    		$.ajax({
    			url : url,
    			type : "post",
    			data : data,
    			success : function(data2){
    				let check = data2;
    				if(check){
    					url = "http://localhost:8080/login";
    					$.ajax({
    						url : url,
    						type : "post",
    						data : data,
    						success : function(data){
    							location.href = "http://localhost:8080/index"
    						}
    					});
    				} else {
    					alert("허용되지 않은 ip주소입니다.");
    					location.href = "http://localhost:8080/signup"
    				}
    			}
    		});
    		})
    	}
    </script>
</body>
</html>