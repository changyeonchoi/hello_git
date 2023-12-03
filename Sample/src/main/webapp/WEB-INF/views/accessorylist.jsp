<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Fashion</title>
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

	nav, section, aside {
		float: left;
/* 		height: 100px; */
	}
	nav {
	height : 500px;
    width: 100px;
    border-right: 2px solid black; /* 오른쪽 선 스타일 설정 */
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
    .menu-items h5 a {
        color: black; /* 기본 텍스트 색상을 지정합니다. */
        text-decoration: none; /* 밑줄을 제거합니다. */
        transition: color 0.3s; /* 색상 변경 시 부드럽게 애니메이션을 적용합니다. */
    }
    .menu-items h5 a.red-text {
        color: red; /* 특정 클래스가 적용된 경우에만 텍스트 색상을 빨간색으로 변경합니다. */
    }
    .menu-items h5 a:hover {
        color: red; /* 마우스를 올렸을 때 텍스트 색상을 빨간색으로 변경합니다. */
    }
    table {
    	width: 50%;
	}
	th, td {
   		border: 1px solid black;
    	padding: 10px;
    	text-align: center;
	}
	th {
    	background-color: black;
    	color: white; /* 텍스트 색상을 하얀색으로 설정 */
	}
	table {
   	 	width: 100%; /* 표의 너비를 70%로 설정 */
   	 	border-collapse: collapse;
	}
 	.underline-input {
    	display: flex;
    	align-items: center;
    	width: 300px;
    	margin-bottom: 20px;
  	}
  	.input-field {
    	flex: 1;
    	border: none;
    	border-bottom: 1px solid black;
   		margin-right: 10px;
    	padding: 5px;
    	font-size: 16px;
  	}
  	.search-button {
    	width: 24px; /* 돋보기 이미지의 너비로 설정 */
    	height: 24px; /* 돋보기 이미지의 높이로 설정 */
    	background: url('/resources/img/search.png') no-repeat center center;
    	border: none;
    	cursor: pointer;
  	}
    .section-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .section-header h3 {
        margin: 0;
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
</style>
 
</head>
<body>
	<div id="wapper">
		<!--헤더시작-->
		<header>
			<div class="menu">
    		<h3><a href="#" class="red-text">상품관리</a></h3>
    		<h3><a href="#">배너관리</a></h3>
    		<h3><a href="adminlist">사용자관리</a></h3>
			</div>
		</header>
		<!--네비게이션-->
		<nav>
			<div class="menu-items">
    			<h3>사용자관리</h3>
    			<h5><a href="fashionlist">Fashion</a></h5>		
    			<h5><a href="makeuplist">Make Up</a></h5>
    			<h5><a href="#" class="red-text">Accessory</a></h5>	
			</div>
		</nav>
		<!--콘텐츠부분-->
		<section>
			<div class="section-header">
        		<h3>Fashion 상품 리스트 목록</h3>
        			<div class="underline-input">
            			<input type="text" value="${search}" placeholder="제목을 입력해주세요" name="search" class="input-field"/>
            			<button onclick="searchDate()" class="search-button"></button>
        			</div>
    		</div>
			<table>
        		<tr>
            		<th>NO</th>
            		<th>등록일</th>
            		<th>제목</th>
            		<th>노출여부</th>
            		<th>등록자ID</th>
        		</tr>
        		<tr>
            		<td>1</td>
            		<td>2023.11.20</td>
            		<td>겨울 맞춤코디</td>
            		<td>미노출</td>
            		<td>tjdms476</td>
        		</tr>
        		<tr>
            		<td>2</td>
            		<td>2023.11.20</td>
            		<td>자켓</td>
            		<td>노출</td>
            		<td>gkgk22</td>
        		</tr>
        		<tr>
            		<td>3</td>
            		<td>2023.11.20</td>
            		<td>여름 반팔</td>
            		<td>노출</td>
            		<td>tprny2</td>
        		</tr>
    		</table><br><br>
    		<div style="text-align: right; float: right;">
            	<button class="custom-button" id="insertButton">등록</button>
            </div>
		</section>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    // 목록 버튼 클릭 시 실행될 함수
    $("#insertButton").click(function() {
    	// adminlist로 이동
    	window.location.href = 'fashioninsert'; // fashioninsert.jsp로 이동
    });
    </script>
</body>
</html>