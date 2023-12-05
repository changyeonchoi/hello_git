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
	#listButton {
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
        .filebox {
        position: relative;
        display: flex;
        align-items: center;
    }

    .filebox .file-label {
        padding: 0px 10px;
        background-color: #999999;
        cursor: pointer;
        margin-left: 10px;
        border: 1px solid black;
        border-radius: 1px;
    }

    .filebox .upload-name {
        height: 20px;
        padding: 0 10px;
        border: 1px solid #dddddd;
        color: #999999;
    }

    .filebox .upload-status {
        color: red;
        margin-left: 10px;
    }

    .filebox input[type="file"] {
        position: absolute;
        width: 0;
        height: 0;
        overflow: hidden;
        border: 0;
    }
    .filebox {
    position: relative;
    display: flex;
    align-items: center;
}

.filebox .file-label {
    padding: 0px 10px;
    background-color: #999999;
    cursor: pointer;
    margin-left: 10px;
    border: 1px solid black;
    border-radius: 1px;
}

.filebox .upload-name-detail {
    height: 20px;
    padding: 0 10px;
    border: 1px solid #dddddd;
    color: #999999;
}

.filebox .upload-status-detail {
    color: red;
    margin-left: 10px;
}

.filebox input[type="file"] {
    position: absolute;
    width: 0;
    height: 0;
    overflow: hidden;
    border: 0;
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
    		<h3><a href="#">사용자관리</a></h3>
			</div>
		</header>
		<!--네비게이션-->
		<nav>
			<div class="menu-items">
    			<h2>Fashion 상품 등록하기</h2>
    				<div>1. 게시글 정보</div><br>
        				<form action="fashionenroll" method="post" enctype="multipart/form-data">
        				<table border="1" style="width: 70%;">
            				<tr>
                				<td class="black-cell">제목*</td>
                				<td><input type="text" class="input_text" id="banner_title" value="" maxlength="15"></td>
            				</tr>
        				</table><br>
        				<div>2.상품 정보</div><br>
    					<table border="1" style="width: 70%;">
        					<tr>
                				<td class="black-cell">상품명*</td>	
                        		<td><input type="text" class="input_text" id="product_name" value="" maxlength="13"></td>
           					</tr>
            				<tr>
                				<td class="black-cell">이미지등록*</td>
                       			<td>
									<div class="filebox">
									    <input class="upload-name" value="파일선택" placeholder="파일선택">
									    <label for="file_img" class="file-label">이미지 찾기</label> 
									    <input type="file" id="file_img">
									    <span class="upload-status"></span>
									</div>
								</td>
            				</tr>
            				<tr>
                				<td class="black-cell">상품가격*</td>
                				<td><input type="text" class="input_text" id="product_amount" value=""></td>
            				</tr>
            				<tr>
                				<td class="black-cell">배송비*</td>
                        		<td><input type="text" class="input_text" id="delivery_fee" value=""></td>
            				</tr>
            				<tr>
                				<td class="black-cell">판매업체*</td>
                        		<td><input type="text" class="input_text" id="company_name" value="" maxlength="10"></td>
            				</tr>
            				<tr>
                				<td class="black-cell">상세정보 이미지*</td>
                        		<td>
                        			<div class="filebox">
								        <input class="upload-name-detail" value="${fashionvo.detail_img}" placeholder="파일선택" readonly>
								        <label for="detail_img" class="file-label">이미지 찾기</label> 
								        <input type="file" id="detail_img" >
								        <span class="upload-status-detail"></span>
   									 </div>
   								</td>
            				</tr>
            				<tr>
                				<td class="black-cell">업체전화번호*</td>
                        		<td><input type="text" class="input_text" id="company_phone" value="" maxlength="13"></td>
           					</tr>
            				<tr>
    						<td class="black-cell">노출여부*</td>
   								<td>
        						<label><input type="radio" name="company_yn" value="Y">노출</label>
        						<label><input type="radio" name="company_yn" value="N">미노출</label>
    							</td>
            				</tr>
    					</table>
    					</form>
    					<br>
    				 <!-- 삭제 버튼 -->
                	<div style="text-align: left; float: left;">
    					<button id="listButton">취소</button>
					</div>
                <!-- 목록 버튼 -->
                	<div style="text-align: right; float: right;">
    					<button class="custom-button" id="saveButton">등록</button>
					</div>
			</div>
		</nav>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
$(document).ready(function() {
    // 상품가격 입력 필드에 대한 이벤트 리스너 추가
    $("#product_amount").on("input", function() {
        // 현재 입력된 값
        var inputValue = $(this).val();

        // 입력된 값에서 숫자와 소수점을 제외한 문자 제거
        var sanitizedValue = inputValue.replace(/[^0-9.]/g, '');

        // 소수점이 여러 개인 경우 첫 번째 소수점만 유지
        var dotIndex = sanitizedValue.indexOf('.');
        if (dotIndex !== -1) {
            sanitizedValue = sanitizedValue.slice(0, dotIndex + 1) + sanitizedValue.slice(dotIndex + 1).replace(/\./g, '');
        }

        // 숫자에 콤마 추가하여 표시
        var formattedValue = Number(sanitizedValue).toLocaleString('en-US', { maximumFractionDigits: 2 });

        // 제한된 값을 다시 입력 필드에 설정
        $(this).val(formattedValue);
    });

    // 배송비 입력 필드에 대한 이벤트 리스너 추가
    $("#delivery_fee").on("input", function() {
        // 현재 입력된 값
        var inputValue = $(this).val();

        // 입력된 값에서 숫자와 띄어쓰기만 남기고 나머지 문자 제거
        var sanitizedValue = inputValue.replace(/[^0-9\s]/g, '');

        // 띄어쓰기를 제거하여 숫자만 남김
        var numericValue = sanitizedValue.replace(/\s/g, '');

        // 숫자에 콤마 추가하여 표시
        var formattedValue = numericValue.replace(/\B(?=(\d{3})+(?!\d))/g, ",");

        // 제한된 값을 다시 입력 필드에 설정
        $(this).val(formattedValue);
    });

    $("#company_phone").on("input", function() {
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

    // 라디오 버튼의 변경 이벤트 리스너 추가
    $("input[name='company_yn']").change(function() {
        // 선택된 라디오 버튼의 값을 가져와서 출력
        var selectedValue = $("input[name='company_yn']:checked").val();
        console.log("선택된 값: " + selectedValue);
    });

    // 등록 버튼 클릭 시 실행될 함수
    $("#saveButton").click(function() {
        // 사용자가 입력한 값들을 가져오기
        var banner_title = $("#banner_title").val();
        var product_name = $("#product_name").val();
        var file_img = $("#file_img")[0].files[0]; // Get the file object
        var product_amount = $("#product_amount").val();
        var delivery_fee = $("#delivery_fee").val();
        var company_name = $("#company_name").val();
        var detail_img = $("#detail_img")[0].files[0]; // Get the file object
        var company_phone = $("#company_phone").val();
        var company_yn = $("input[name='company_yn']:checked").val(); // Get the selected radio button value

        // 필수 입력 필드 체크
        if (!banner_title || !product_name || !file_img || !product_amount || !delivery_fee || !company_name || !detail_img || !company_phone || !company_yn) {
            alert("모든 항목을 입력해주세요.");
            return; // 필수 입력 필드 중 하나라도 빈 값이면 함수 종료
        }
        
        // Create FormData object
        var formData = new FormData();
        formData.append("banner_title", banner_title);
        formData.append("product_name", product_name);
        formData.append("file_img", file_img);
        formData.append("product_amount", product_amount);
        formData.append("delivery_fee", delivery_fee);
        formData.append("company_name", company_name);
        formData.append("detail_img", detail_img);
        formData.append("company_phone", company_phone);
        formData.append("company_yn", company_yn);

        console.log(formData);

        // 서버에 데이터를 전송하는 Ajax 호출
        $.ajax({
            url: '/fashionenroll',
            method: 'POST',
            data: formData,
            dataType: "text",
            enctype: 'multipart/form-data',
            contentType: false,
            processData: false,
            success: function(response) {
                // 등록 성공 시 알림 표시 후 목록 페이지로 이동
                alert('상품이 등록되었습니다.');
                window.location.href = 'fashionlist'; // 등록 후 이동할 페이지 URL로 변경해주세요
            },
            error: function(error) {
                // 등록 실패 시 알림 표시
                alert('상품 등록에 실패하였습니다. 다시 시도해주세요.');
                console.error('Error:', error);
            }
        });
    });

    // 목록 버튼 클릭 시 실행될 함수
    $("#listButton").click(function() {
        // 목록 페이지로 이동
        window.location.href = 'fashionlist'; // 목록 페이지 URL로 변경해주세요
    });
    
    $("#file_img").on('change',function(){
  	  var fileName = $("#file_img").val();
  	  $(".upload-name").val(fileName);
  	  $(".upload-status").text("*업로드 완료");
  });  
  
  $("#detail_img").on('change', function () {
      var detailName = $("#detail_img").val();
      $(".upload-name-detail").val(detailName);
      $(".upload-status-detail").text("*업로드 완료");
  });
});
</script>
</body>
</html>