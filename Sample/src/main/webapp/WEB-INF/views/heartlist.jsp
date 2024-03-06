<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>찜 현황</title>
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
</style>
 
</head>
<body>
	<div id="wapper">
		<!--헤더시작-->
		<header>
			<div class="menu">
    		<h3><a href="fashionlist">상품관리</a></h3>
    		<h3><a href="bannerlist">배너관리</a></h3>
    		<h3><a href="adminlist">사용자관리</a></h3>
			</div>
		</header>
		<!--콘텐츠부분-->
		<section>
			<div class="section-header">
        		<h3>찜 현황</h3>
				<select id="product_selection">
            		<option value="most-selected">가장 많이 선택된 상품</option>
            		<option value="least-selected">가장 적게 선택된 상품</option>
        		</select>
    		</div><br>
		<table border="1" id="tableContainer">
		    <thead>
		        <tr>
		            <th>NO</th>
		            <th>상품명</th>
		            <th>찜횟수</th>
		        </tr>
		    </thead>
		
		    <tbody>
		    	<c:forEach var="heartList" items="${heartList}" varStatus="status">
		    		<tr>
		    			<td>${status.index + 1}</td>
		    			<td>${heartList.product_name}</td>
		    			<td>${heartList.heart_count}</td>
		    		</tr>
		    	</c:forEach>
		    </tbody>
		</table>
	</section>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
    $(document).ready(function() {
    	$("#product_selection").change(function() {
        	
    		var product_selection = $(this).val();
            
            var product_selection = JSON.stringify({
                product_selection: product_selection
            });
            
            console.log("product_selection" + product_selection);
            
            $.ajax({
                type: "post",
                url: "/heartlist", 
                data: product_selection,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function(data) {
                    // 서버에서 받은 데이터를 처리
                    console.log("data" + data);
                 	updateTable(data);
                },
                error: function(error) {
                	console.error('Error:', error);
                }
            });
        });
        
        function updateTable(data) {
            console.log("Received data:", data); // 서버 응답 데이터 확인

            // 테이블 내용 초기화
            var tbody = $("#tableContainer tbody");
            tbody.empty();

            // 서버에서 받은 데이터를 이용하여 테이블 업데이트
            for (var i = 0; i < data.length; i++) {
                var row = "<tr>" +
                            "<td>" + (i + 1) + "</td>" +
                            "<td>" + data[i].product_name + "</td>" +
                            "<td>" + data[i].heart_count + "</td>" +
                          "</tr>";

                tbody.append(row);
            }
        }
    });
	</script>
</body>
</html>