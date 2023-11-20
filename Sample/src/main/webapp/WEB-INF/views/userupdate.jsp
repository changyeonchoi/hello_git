<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>HTML5</title>
<style type="text/css">
	body {
		text-align: center;
/* 		color: #FFF; */
		width: 900px;
	}
	div#wapper {
		width: 100%;
		text-align: left;
		min-height: 300px;
		margin: 0 auto;
	}
 	header, footer, nav, aside, section { 
/*  		border: 1px solid #999;  */
 		margin: 5px; 
/*  		padding: 10px;  */
 	} 
	section {
/* 		background-color: green;	 */
		width: 775px; 
	}
	article {
		width: 90%;
		margin: 20px;
		background-color: #999;
	}
	.menu {
      margin-bottom: 20px; /* 선과의 간격 조절 가능 */
      display: flex;
      align-items: center; /* 세로 가운데 정렬 */
      border-bottom: 2px solid black; /* 메뉴 아래 수평선 */
      padding-bottom: 10px; /* 수평선 아래 여백 */
    }
    .menu h3 {
        display: inline;
        margin-right: 20px; /* 텍스트 간격을 조절할 수 있습니다. */
    }
    .menu h3:last-child {
        margin-right: 0; /* 마지막 메뉴 아이템의 오른쪽 마진을 제거합니다. */
    }
    .menu h3 a {
        color: black; /* 기본 텍스트 색상을 지정합니다. */
        text-decoration: none; /* 밑줄을 제거합니다. */
        transition: color 0.3s; /* 색상 변경 시 부드럽게 애니메이션을 적용합니다. */
    }
    .menu h3 a.red-text {
        color: red; /* 특정 클래스가 적용된 경우에만 텍스트 색상을 빨간색으로 변경합니다. */
    }
    .menu h3 a:hover {
        color: red; /* 마우스를 올렸을 때 텍스트 색상을 빨간색으로 변경합니다. */
    }
	.black-cell {
  		background-color: black;
    	color: white;
    	text-align: center;
	}
	#deleteButton {
        background-color: white; /* 배경색을 흰색으로 설정 */
        color: black; /* 글자색을 검정색으로 설정 */
        padding: 10px 20px; /* 안쪽 여백 설정 */
        font-size: 16px; /* 글자 크기 설정 */
        border: 1px solid black; /* 테두리 설정 */
/*         border-radius: 5px; /* 모서리를 둥글게 만듦 */ */
        cursor: pointer; /* 커서를 포인터로 변경하여 버튼임을 나타냄 */
    }
        .custom-button {
        background-color: black; /* 배경색을 검정색으로 설정 */
        color: white; /* 글자색을 흰색으로 설정 */
        padding: 10px 20px; /* 안쪽 여백 설정 */
        font-size: 16px; /* 글자 크기 설정 */
        border: none; /* 테두리 없음 */
/*         border-radius: 5px; /* 모서리를 둥글게 만듦 */ */
        cursor: pointer; /* 커서를 포인터로 변경하여 버튼임을 나타냄 */
        margin-bottom: 10px; /* 하단 마진 설정 */
    }
    .input_text {
/*     	text-align: center; */
    	width: 90%; 
    	margin: 0 auto;
    }
</style>
 
</head>
<body>
	<div id="wapper">
		<!--헤더시작-->
		<header>
			<div class="menu">
    		<h3><a href="#">상품관리</a></h3>
    		<h3><a href="#">배너관리</a></h3>
    		<h3><a href="#" class="red-text">사용자관리</a></h3>
			</div>
		</header>
		<!--네비게이션-->
		<nav>
			<div class="menu-items">
    			<h2>관리자 상세보기</h2>
    				<div>1. 관리자정보</div><br>
        				<table border="1" style="width: 90%;">
            				<tr>
                				<td class="black-cell">회원 ID</td>
                				<td><input type="text" class="input_text" id="user_id" value="${membervo.user_id}" readonly></td>
            				</tr>
            				<tr>
                				<td class="black-cell">이름*</td>
                        		<td><input type="text" class="input_text" id="user_name" value="${membervo.user_name}" readonly></td>
           					</tr>
            				<tr>
                				<td class="black-cell">패스워드*</td>
                				<td><input type="password" class="input_text" id="user_pw" value="${membervo.user_pw}" readonly></td>
            				</tr>
            				<tr>
                				<td class="black-cell">연락처*</td>
                       			<td><input type="text" class="input_text" id="user_phone" value="${membervo.user_phone}" readonly></td>
            				</tr>
        				</table><br>
    				 <!-- 삭제 버튼 -->
                	<div style="text-align: left; float: left;">
    					<button id="deleteButton">삭제</button>
					</div>
                <!-- 목록 버튼 -->
                	<div style="text-align: right; float: right;">
                		<button class="custom-button" id="listButton">목록</button>
					</div>
			</div>
		</nav>
	</div>
	    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    	 $(document).ready(function() {
    	        // 삭제 버튼 클릭 시 실행될 함수
    	        $("#deleteButton").click(function() {
    	            var user_id = $("#user_id").val(); // 삭제할 사용자 ID 가져오기

    	            // 서버에 삭제 요청을 보내는 Ajax 호출
    	            $.ajax({
    	                url: '/userdelete', // 삭제를 처리하는 서버의 엔드포인트 URL로 변경해주세요
    	                method: 'POST',
    	                data: { user_id: user_id }, // 삭제할 사용자 ID를 서버에 전달
    	                success: function(response) {
    	                    // 삭제 성공 시 알림 표시 후 admin.jsp로 이동
    	                    alert('관리자가 삭제되었습니다.');
    	                    window.location.href = 'adminlist'; // admin.jsp로 이동
    	                },
    	                error: function(error) {
    	                    // 삭제 실패 시 알림 표시
    	                    alert('삭제에 실패하였습니다. 다시 시도해주세요.');
    	                    console.error('Error:', error);
    	                }
    	            });
    	        });
    	        
                // 목록 버튼 클릭 시 실행될 함수
                $("#listButton").click(function() {
                    // adminlist로 이동
                    window.location.href = 'userlist'; // adminlist.jsp로 이동
                });
    	 });
    </script>
</body>
</html>