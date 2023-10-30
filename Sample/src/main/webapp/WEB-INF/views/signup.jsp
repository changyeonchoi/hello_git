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
		<h1>회원가입</h1>
	 		<div class="textForm">
	    		<input type="text" class="input_text" id="userid" placeholder="아이디">
			</div>
			<div class="textForm">
		  		<input type="password" class="input_text" id="userpw" placeholder="비밀번호">
	    	</div>
    		<div class="text_center">
			    <button type="button" class="btn" id="btn_signup">가입하기</button>
			  	<input type="reset" class="btn" value="다시입력">
		  	</div>
 	</form>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    	
    	$(function(){
    		bind();
    	});
    	
    	function bind(){
    		
    		$("#btn_signup").off("click").on("click", function(){
    			
    			console.log("btn_signup")
    			
    			let id = $("#userid").val();
    			let pwd = $("#userpw").val();
    			console.log("id:", id , "pwd:", pwd);
    			
    			let data = {
						"userid" : id,
						"userpw" : pwd
					}
					
				let url = "http://localhost:8080/signupCheck";
    			
    			$.ajax({
					url: url,
					type: "get",
					data: data,
					contentType: 'application/json; charset=UTF-8',
					success : function(data){
						let result = data;
						console.log("ajax result: ", result);
						
						if(result){
							alert(id + " 님 가입을 축하드립니다.");
							let page = "http://localhost:8080/login"
							location.replace(page);
						} else {
							alert("동일한 id가 있습니다.");
						}
					},
					fail : function(data){
						console.log("fail, "+data);
					},
					complete: function(data){
						console.log("comp", data);
					}
				})
	    		
    		});
    	}
    
    </script>

</body>
</html>