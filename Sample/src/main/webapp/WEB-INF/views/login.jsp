<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<style>
    .center-align {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    
   .button-container-black {
        background-color: black;
        color: white;
        padding: 10px 65px;
        border: none;
/*         margin-right: 1px; /* 신청 버튼의 오른쪽 마진을 10px로 설정 */ */
    }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="center-align">
	<h1 style="margin: 0;"><span style="color:red;">BT</span>   LOGIN</h1>
	<form style="border: 2px solid red; padding: 20px;">
		
		<input type="text" id="userid" placeholder="회원ID" required /><br><br>
		<input type="password" id="userpw" placeholder="패스워드" /><br><br>
		<input type="button" id="btn_login" class="button-container-black" value="LOGIN" />
	</form>
</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    	$(function(){
    		bind();
    	});
    	
    	function bind(){
    		
    		$("#btn_login").off("click").on("click", function(){
    			
    			let user_id = $("#userid").val();
    			let user_pw = $("#userpw").val();
    			console.log("Test", user_id, user_pw);
    			
    			let data = {
    					user_id : user_id,
    					user_pw : user_pw
    			}
    		
    		let url = "http://localhost:8080/loginCheck";
    			
    		console.log(data);
    			
    		$.ajax({
    			url : url,
    			type : "post",
    			data : data,
//     			console.log("data" + data);
    			success : function(result){
    				console.log(result);
    				let check = result;
    				console.log("result" + result);
    				if(check){
    					alert("로그인 성공");
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
    					alert("아이디 또는 패스워드가 일치하지 않습니다.");
    					let popupUrl = "http://localhost:8080/signup?user_id=" + encodeURIComponent(user_id);
    					window.open(popupUrl, "_blank", "width=800, height=600");
    				}
    			}
    		});
    		})
    	}
    </script>
</body>
</html>