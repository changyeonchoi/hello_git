<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	.box {
  top: 44%;
  padding: 20px 50px 20px 20px;
  height: 30vh;
  left: 5%;
}

#main-box {
  width: 75%;
}

.top-box {
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  width: 65%;
  margin: 2px auto;
}
.top-box .top-box__total {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 10%;
  margin-right: 5px;
  margin-bottom: 20px;
  cursor: pointer;
}
.top-box .top-box__total p {
  font-weight: 600;
  font-size: 1.1em;
}

.top-box__total:last-child {
  width: 47%;
  margin-bottom: 10px;
}
.top-box__total:last-child p {
  font-weight: 600;
  font-size: 1.1em;
  margin-right: 5px;
  border-right: 1px solid #333;
  padding-right: 40px;
}

.selected {
  font-size: 1.1em;
  font-weight: 600;
}
.red-text {
  color: #d1180b;
}
.ordered-product {
  width: 70%;
  margin: 91px auto 0;
}
.ordered-product .notice__detail--box {
  padding: 0;
  margin: 0;
}

.title__box {
  border: unset;
}
</style>
 
</head>
<body>
	<div id="wapper">
		<!--헤더시작-->
		<header>
			<div class="menu">
    		<h3><a href="fashionlist">상품관리</a></h3>
    		<h3><a href="bannerlist">배너관리</a></h3>
    		<h3><a href="#" class="red-text">사용자관리</a></h3>
			</div>
		</header>
		<!--네비게이션-->
		<nav>
			<div class="menu-items">
    			<h2>관리자 상세보기</h2>
    				<div>1. 사용자 정보</div><br>
        				<table border="1" style="width: 90%;">
            				<tr>
                				<td class="black-cell">회원 ID</td>
                				<td><input type="text" class="input_text" id="user_id" value="${membervo.user_id}" placeholder=""></td>
            				</tr>
            				<tr>
                				<td class="black-cell">이름*</td>
                        		<td><input type="text" class="input_text" id="user_name" value="${membervo.user_name}" maxlength="10"></td>
           					</tr>
            				<tr>
                				<td class="black-cell">주문횟수*</td>
                       			<td><input type="text" class="input_text" id="user_phone" value="${membervo.user_phone}" maxlength="13"></td>
            				</tr>
        				</table><br><br><br>
        				<div>2. 주문 정보</div><br>
							<div class="ordered-product">
							    <div class="notice__detail--box">
							        <div class="detail__notice">
									    <c:forEach var="OrderList" items="${OrderList}">
									            <div class="info__box--title">
									                <div class="title__box" style="border: unset">
									                    <p style="width: 100%; text-align: left; padding-left: 15px">${OrderList.regdate}</p>
									                </div>
									                <div class="title__box">
									                    <p>상품명</p>
									                    <input type="text" class="title__box--user" placeholder="${OrderList.product_name}" style="cursor: auto" disabled />
									                </div>
									            </div>
									     </c:forEach>       
										<div class="center-div">${navigation}</div>
							        </div>
							    </div>
							</div>
    				 <!-- 삭제 버튼 -->
                	<div style="text-align: left; float: left;">
    					<button id="deleteButton">삭제</button>
					</div>
                <!-- 목록 버튼 -->
                	<div style="text-align: right; float: right;">
                		<button class="custom-button" id="listButton">목록</button>
    					<button class="custom-button" id="saveButton">저장</button>
					</div>
			</div>
		</nav>
	</div>
	    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    	
    
    	$(document).ready(function() {
	    	// URL에서 user_id 파라미터 값을 가져오는 함수
	    	function getUserIDFromURL() {
	        	const urlParams = new URLSearchParams(window.location.search);
	        	return urlParams.get('user_id');
	    	}

	    	// URL에서 가져온 user_id 값을 인풋창에 설정
	    	var userid = getUserIDFromURL();
	    	if (userid) {
	    		$("#user_id").val(userid);
	    	    // 값이 이미 들어있으면 수정할 수 없도록 설정
	            $("#user_id").attr("readonly", true);
	        } else {
	            // 값이 없으면 수정할 수 있도록 설정
	            $("#user_id").attr("readonly", false);
	    	}
		});
    	
    	$(document).ready(function() {
    	    // 이름 입력창
    	    $("#user_name").on("input", function() {
    	        // 입력 중 공백이 있으면 제거
    	        var inputText = $(this).val();
    	        // 숫자인 경우 숫자를 제거
    	        var sanitizedText = inputText.replace(/\s/g, '').replace(/\d/g, ''); // 공백과 숫자 제거
    	        $(this).val(sanitizedText);
    	    });

    	    // 휴대폰 번호 입력창
    	    $("#user_phone").on("input", function() {
    	        var inputText = $(this).val();
    	        // 숫자와 하이픈만 남기고 모든 문자 제거
    	        var sanitizedText = inputText.replace(/[^\d-]/g, '');

    	        // 하이픈이 자동으로 추가되도록 처리
    	        if (sanitizedText.length > 3 && sanitizedText.charAt(3) !== '-') {
    	            sanitizedText = sanitizedText.slice(0, 3) + '-' + sanitizedText.slice(3);
    	        }
    	        if (sanitizedText.length > 8 && sanitizedText.charAt(8) !== '-') {
    	            sanitizedText = sanitizedText.slice(0, 8) + '-' + sanitizedText.slice(8);
    	        }

    	        // 입력 창에 반영
    	        $(this).val(sanitizedText);
    	    });    
    	    
    	    var user_auth = "${membervo.user_auth}";
    	    
    	    // ID로 <select> 요소를 찾습니다.
    	    var selectElement = $("#user_auth");

    	    // 'user_auth' 값을 기반으로 선택된 옵션을 설정합니다.
    	    selectElement.val(user_auth);
    	});
    	
    	 $(document).ready(function() {
    	        // 삭제 버튼 클릭 시 실행될 함수
    	        $("#deleteButton").click(function() {
    	            var user_id = $("#user_id").val(); // 삭제할 사용자 ID 가져오기

    	            // 서버에 삭제 요청을 보내는 Ajax 호출
    	            $.ajax({
    	                url: '/deleteMember', // 삭제를 처리하는 서버의 엔드포인트 URL로 변경해주세요
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
                    window.location.href = 'userorderlist'; 
                });
    	 });
    </script>
</body>
</html>