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
	#listButton {
        background-color: white; /* 배경색을 흰색으로 설정 */
        color: black; /* 글자색을 검정색으로 설정 */
        padding: 10px 20px; /* 안쪽 여백 설정 */
        font-size: 16px; /* 글자 크기 설정 */
        border: 1px solid black; /* 테두리 설정 */
/*         border-radius: 5px; /* 모서리를 둥글게 만듦 */ */
        cursor: pointer; /* 커서를 포인터로 변경하여 버튼임을 나타냄 */
    }
    .coupon-button {
        background-color: black;
        color: white;
        width: 160px; /* 너비 조절 */
        height: 40px; /* 높이 조절 */
    }
    .gray-button {
        background-color: gray !important;
        color: black !important;
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
		<!--콘텐츠부분-->
		<section>
			<div class="section-header">
        		<h3>쿠폰 연동상품 등록</h3><br><br><br>
	                <select class="input_text_selected" id="banner_area2" onchange="getProductList()">
						<option value="">===선택===</option>
						<option value="fashion">Fashion</option>
						<option value="makeup">Make Up</option>
						<option value="accessory">Accessory</option>
	        		</select>
	        		<div id="productList"></div>
        			<div class="underline-input">
            			<input type="text" id="searchInput" placeholder="제목을 입력해주세요" class="input-field"/>
            			<button onclick="goSearch()" class="search-button"></button>
        			</div>
    		</div>
		<table border="1" id="tableContainer">
    <tr>
        <th>NO</th>
        <th>제목</th>
        <th>가져오기</th>
        <th>매핑 쿠폰명</th>
    </tr>

<c:forEach var="coupon" items="${CouponProductList}" varStatus="status">
    <tr>
        <td>${coupon.rnum}</td>
        <td>
            <a href="#" class="detail-link" data-seq-id="${coupon.seq_id}">
                ${coupon.product_name}
            </a>
        </td>
        <td>
            <button type="button" class="coupon-button"
                    data-product-seq-id="${coupon.seq_id}"
                    onclick="selectProductAndClose(${coupon.seq_id}, '${coupon.product_name}')"
                    ${not empty coupon.banner_name ? 'disabled' : ''}>
                가져오기
            </button>
        </td>
        <td>${coupon.banner_name}</td>
    </tr>
</c:forEach>
		</table>
		<div class="center-div">${navigation}</div><br>
            <div style="text-align: center; float: center;">
    			<button id="listButton">취소</button>
			</div>
		</section>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    function selectProductAndClose(seq_id, product_name) {
        // 부모 창에 접근
        var parentWindow = window.opener;

        var selectedProduct = {
            product_name: product_name,
            // 다른 상품 정보들도 필요에 따라 추가
        };

        // 필요한 동작 수행 (예: seq_id와 product_name 값을 부모 창으로 전달)
        if (parentWindow && seq_id) {  
            parentWindow.handleSelectedProduct(seq_id, selectedProduct);
        }

        // 현재 창 닫기
        window.close();
    }
    
    $("#listButton").click(function() {
        // 목록 페이지로 이동
        window.close(); // 목록 페이지 URL로 변경해주세요
    });

    function getProductList() {
    	
        var selectedValue = $("#banner_area2").val();

        $.ajax({
            type: "GET",
            url: "/couponproductlist",
            contentType: "application/json",
            data: {
                product_code: selectedValue
            },
            success: function(response) {
                updateTable(response, selectedValue); // 선택된 값을 함수에 전달
            },
            error: function(error) {
                console.error("Error fetching product list: " + error);
            }
        });
    }
    
    $(document).ready(function() {
        // 클래스가 detail-link인 요소를 클릭했을 때의 동작 정의
        $('.detail-link').click(function() {
            // data-seq-id 속성을 통해 seq_id 값을 가져옴
            var seqId = $(this).data('seq-id');
            
            console.log("seqId" + seqId);
            
            // seq_id 값을 사용하여 detail 페이지로 이동
//             window.location.href = '/coupondetail?seq_id=' + seqId;
        });
    });
    
    $(document).ready(function() {
        $(".coupon-button").each(function() {
            // 각 버튼에 대해 coupon_name 값을 확인하고 비어있으면 활성화
            var couponName = $(this).closest('tr').find('td:eq(3)').text().trim();
            if (couponName === '') {
                $(this).prop('disabled', false);
            } else {
                $(this).prop('disabled', true);
                $(this).addClass('gray-button');
            }
        });

        $(".coupon-button").click(function() {
            // 클릭된 버튼 가져오기
            var clickedButton = $(this);

            // 클릭된 버튼을 딤(Dim) 처리하고 비활성화(disable)하기
            clickedButton.prop('disabled', true); // 버튼 비활성화
            clickedButton.css('opacity', '0.5'); // 투명도 조절 (옵션)

            // 여기에 추가적인 로직을 추가하십시오.
        });
    });

    function updateTable(newTableHtml, selectedValue) {
        // 기존 테이블 지우기
        $("#wapper").empty();
        
        // 새로운 데이터로 테이블 그리기
        $("#wapper").html(newTableHtml);

        // 선택된 값으로 설정
        $("#banner_area2").val(selectedValue);
    }
    
    function goSearch() {
        let search = $("#searchInput").val();
        let product_code = $("#banner_area2").val(); // 추가된 부분: code 값 가져오기

        // URL 생성
        let url = "<c:url value='/couponproductlist'/>?search=" + search + "&product_code=" + product_code;

        // 페이지 이동
        $(location).attr('href', url);
    }
    </script>
</body>
</html>