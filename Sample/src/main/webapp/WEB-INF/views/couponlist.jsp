<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>coupon</title>
<style type="text/css">
	.center-div {
    	width: 100%;
    	text-align: center;
    	margin-top: 20px; /* 필요에 따라 조절 가능한 상단 여백 */
	}
	.pagination {
    	margin: 0 5px; /* 페이지 번호와 부등호 사이의 간격을 조절할 수 있습니다. */
	}

	.page-number {
    	text-decoration: none;
    	padding: 3px 5px; /* 페이지 번호의 간격 및 여백을 조절할 수 있습니다. */
    	border: 1px solid #ccc; /* 페이지 번호의 테두리를 추가할 수 있습니다. */
    	color: #333; /* 페이지 번호의 글자색을 조절할 수 있습니다. */
	}

	.page-number:hover {
    	background-color: #f5f5f5; /* 마우스 오버 시 배경색을 변경할 수 있습니다. */
	}
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
    		<h3><a href="fashionlist">상품관리</a></h3>
    		<h3><a href="bannerlist" class="red-text">배너관리</a></h3>
    		<h3><a href="adminlist">사용자관리</a></h3>
			</div>
		</header>
		<!--네비게이션-->
		<nav>
			<div class="menu-items">
    			<h3>배너관리</h3>
    			<h5><a href="bannerlist">메인빅배너 관리</a></h5>		
    			<h5><a href="couponlist" class="red-text">쿠폰 관리</a></h5>
			</div>
		</nav>
		<!--콘텐츠부분-->
		<section>
			<div class="section-header">
        		<h3>쿠폰 리스트 목록</h3>
        			<div class="underline-input">
            			<input type="text" id="searchInput" placeholder="배너명을 입력하세요" class="input-field"/>
            			<button onclick="goSearch()" class="search-button"></button>
        			</div>
    		</div>
		<table border="1" id="tableContainer">
    <tr>
        <th>NO</th>
        <th>등록일</th>
        <th>배너명</th>
        <th>노출여부</th>
        <th>등록자ID</th>
    </tr>

    <c:forEach var="coupon" items="${coupon}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>
            <fmt:parseDate value="${coupon.redate}" var="redate" pattern="yyyy-mm-dd"/>
            <fmt:formatDate value="${redate}" pattern="yyyy.mm.dd"/>
            </td>
            <td>
            <a href="#" class="detail-link" data-seq-id="${coupon.seq_id}">
                ${coupon.banner_name}
            </a>
            </td>
            <td>${coupon.banner_yn}</td>
            <td>${coupon.user_id}</td>
        </tr>
    </c:forEach>
		</table>
		<div class="center-div">${navigation}</div>
    		<div style="text-align: right; float: right;">
            	<button class="custom-button" id="insertButton">등록</button>
            </div>
		</section>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    // jQuery를 사용하여 클릭 이벤트 처리
    $(document).ready(function() {
        // 클래스가 detail-link인 요소를 클릭했을 때의 동작 정의
        $('.detail-link').click(function() {
            // data-seq-id 속성을 통해 seq_id 값을 가져옴
            var seqId = $(this).data('seq-id');
            
            console.log("seqId" + seqId);
            
            // seq_id 값을 사용하여 detail 페이지로 이동
            window.location.href = '/coupondetail?seq_id=' + seqId;
        });
    });
//     $(document).on('click', '#tableContainer td:nth-child(3)', function() {
//         var user_id = $(this).text(); // 클릭한 행의 user_id 값을 가져옴
//         window.location.href = '/adminupdate?user_id=' + banner_title; // adminupdate.jsp로 이동하면서 user_id를 파라미터로 전달
//     });

    $("#insertButton").click(function() {
    	window.location.href = '/couponinsert'; 
    });
    
    function goSearch(){
    	let search = $("#searchInput").val();
    	$(location).attr('href',"<c:url value='/couponlist?search="+search+"'/>");
    }
    function goPage(pageNo){
    	let searchInputValue = $("#searchInput").val();
    	$(location).attr('href',"<c:url value='/couponlist?pageNo="+pageNo+"'/>");
    }
    function golist() {
        // Fashion 링크 클릭 시 검색어를 제외하고 이동
        $(location).attr('href', "<c:url value='/couponlist'/>");
    }
    </script>
</body>
</html>