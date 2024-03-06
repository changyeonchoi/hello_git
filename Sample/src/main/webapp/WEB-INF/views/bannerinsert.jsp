<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>banner</title>
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
    .red-text {
    	color: red;
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
    		<h3><a href="fashionlist">상품관리</a></h3>
    		<h3><a href="bannerlist" class="red-text">배너관리</a></h3>
    		<h3><a href="adminlist">사용자관리</a></h3>
			</div>
		</header>
		<!--네비게이션-->
		<nav>
			<div class="menu-items">
    			<h2>메인빅배너 등록하기</h2>
        				<form action="fashionenroll" method="post" enctype="multipart/form-data">
        				<div class="red-text">*한 개의 이미지만 등록 가능합니다.</div><br>
    					<table border="1" style="width: 70%;">
        					<tr>
                				<td class="black-cell">배너명*</td>	
                        		<td><input type="text" class="input_text" id="banner_name" value="" maxlength="15"></td>
           					</tr>
            				<tr>
                				<td class="black-cell">이미지 등록*</td>
                       			<td>
									<div class="filebox">
									    <input class="upload-name" value="파일선택" placeholder="파일선택">
									    <label for="banner_img" class="file-label">이미지 찾기</label> 
    									<input type="file" id="banner_img" accept=".png, .jpeg, .jpg" data-width="2000" data-height="500">
									    <span class="upload-status"></span>
									</div>
								</td>
            				</tr>
            				<tr>
                				<td class="black-cell">노출영역*</td>
                				<td>
	                				<select class="input_text_selected" id="banner_area1">
							            <option value="PC">PC</option>
	        						</select>
	                				<select class="input_text_selected" id="banner_area2">
							            <option value="Home">Home</option>
							            <option value="fashion">Fashion</option>
							            <option value="makeup">Make Up</option>
							            <option value="accessory">Accessory</option>
	        						</select>
        						</td>
            				</tr>
            				<tr>
                				<td class="black-cell">랜딩URL*</td>
                        		<td><input type="text" class="input_text" id="land_url" value=""></td>
            				</tr>
            				<tr>
    						<td class="black-cell">노출여부*</td>
   								<td>
        						<label><input type="radio" name="banner_yn" value="노출" checked>노출</label>
        						<label><input type="radio" name="banner_yn" value="미노출">미노출</label>
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
    // 라디오 버튼의 변경 이벤트 리스너 추가
    $("input[name='banner_yn']").change(function() {
        // 선택된 라디오 버튼의 값을 가져와서 출력
        var selectedValue = $("input[name='banner_yn']:checked").val();
        console.log("선택된 값: " + selectedValue);
    });

    // 등록 버튼 클릭 시 실행될 함수
    $("#saveButton").click(function() {
        // 사용자가 입력한 값들을 가져오기
        var banner_name = $("#banner_name").val();
        var banner_img = $("#banner_img")[0].files[0]; // Get the file object
        var banner_area1 = $("#banner_area1").val();
        var banner_area2 = $("#banner_area2").val();
        var land_url = $("#land_url").val();
        var banner_yn = $("input[name='banner_yn']:checked").val(); // Get the selected radio button value

         // 필수 입력 필드 체크
        if (!banner_name || !banner_img || !banner_area1 || !banner_area2 || !land_url || !banner_yn) {
            alert("모든 항목을 입력해주세요.");
            return; // 필수 입력 필드 중 하나라도 빈 값이면 함수 종료
        }
        
        // Create FormData object
        var formData = new FormData();
        formData.append("code", "banner");
        formData.append("banner_img", banner_img);
        formData.append("banner_area1", banner_area1);
        formData.append("banner_area2", banner_area2);
        formData.append("banner_name", banner_name);
        formData.append("land_url", land_url);
        formData.append("banner_yn", banner_yn);

        // 서버에 데이터를 전송하는 Ajax 호출
        $.ajax({
            url: '/bannerenroll',
            method: 'POST',
            data: formData,
            dataType: "text",
            enctype: 'multipart/form-data',
            contentType: false,
            processData: false,
            success: function(response) {
                // 등록 성공 시 알림 표시 후 목록 페이지로 이동
                alert('등록되었습니다.');
                window.location.href = '/bannerlist';
            },
            error: function(error) {
                // 등록 실패 시 알림 표시
                alert('error');
                console.error('Error:', error);
            }
        });
    });

    // 목록 버튼 클릭 시 실행될 함수
    $("#listButton").click(function() {
        // 목록 페이지로 이동
        window.location.href = '/bannerlist'; // 목록 페이지 URL로 변경해주세요
    });
    
    $(document).ready(function () {
        $("#banner_img").on('change', function () {
            var fileInput = this;
            var fileName = fileInput.value;
            var allowedExtensions = /(\.png|\.jpeg|\.jpg)$/i;

            if (!allowedExtensions.exec(fileName)) {
                alert('허용되지 않는 파일 형식입니다. PNG, JPG 또는 JPEG 파일을 선택해주세요.');
                fileInput.value = ''; // 파일 입력값 초기화
                $(".upload-name").val('파일선택'); // 업로드 이름 초기화
                $(".upload-status").text(""); // 업로드 상태 메시지 초기화
                return false;
            }

            // Read the selected image file
            var reader = new FileReader();
            reader.onload = function (e) {
                var img = new Image();
                img.onload = function () {
                    var maxWidth = parseInt($("#banner_img").data('width'));
                    var maxHeight = parseInt($("#banner_img").data('height'));

                    // Check image dimensions
                    if (img.width > maxWidth || img.height > maxHeight) {
                        alert('이미지 크기가 허용된 최대 크기를 초과합니다. 가로 최대 ' + maxWidth + 'px, 세로 최대 ' + maxHeight + 'px로 선택해주세요.');
                        fileInput.value = ''; // 파일 입력값 초기화
                        $(".upload-name").val('파일선택'); // 업로드 이름 초기화
                        $(".upload-status").text(""); // 업로드 상태 메시지 초기화
                        return false;
                    } else {
                        // Display the image name and upload status
                        $(".upload-name").val(fileName);
                        $(".upload-status").text("*업로드 완료");
                    }
                };
                img.src = e.target.result;
            };

            reader.readAsDataURL(fileInput.files[0]);
        });
    });
});
</script>
</body>
</html>