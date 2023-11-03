<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
	<title>스퀘어네트</title>
<style>
    .menu-items {
        margin-bottom: 20px; /* 선과의 간격 조절 가능 */
    }

    .menu-items h3 {
        display: inline;
        margin-right: 20px; /* 텍스트 간격을 조절할 수 있습니다. */
    }

    .menu-items:after {
        content: "";
        display: block;
        border-bottom: 1px solid black; /* 선의 스타일 지정 */
        margin-top: 10px; /* 선과의 간격 조절 가능 */
    }
</style>
</head>
<body>
<h3><span style="color:red;">BT</span>   CMS</h3>

<div class="menu-items">
    <h3><a href="#">상품관리</a></h3>
    <h3><a href="#">배너관리</a></h3>
    <h3><a href="#">사용자관리</a></h3>
</div>
<div style="display: flex; justify-content: space-between; margin-bottom: 10px;">
    <div>
        <h4>찜 현황</h4>
        <table border="1">
            <tr>
                <th>no</th>
                <th>상품명</th>
                <th>찜횟수</th>
            </tr>
            <tr>
                <td>1</td>
                <td>가을 바람막이</td>
                <td>12회</td>
            </tr>
            <!-- 여기에 다른 찜 현황 데이터를 추가할 수 있습니다. -->
        </table>
    </div>
    <div>
        <h4>상품 정렬 옵션</h4>
        <select id="product-selection">
            <option value="most-selected">가장 많이 선택된 상품</option>
            <option value="least-selected">가장 적게 선택된 상품</option>
        </select>
    </div>
</div>
</body>
</html>
