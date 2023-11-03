<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    .center-align {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .table-container {
        width: 100%;
    }

    .table-container table {
        border: 1px solid black;
        width: 100%;
    }

    .custom-cell {
        background-color: black;
        color: white;
        text-align: center;
    }
    
    .button-container {
        display: flex;
        justify-content: space-between;
        width: 100%;
        margin-top: 10px;
    }

    .button-container button {
        cursor: pointer;
    }

    .button-container button.button-container-black {
        background-color: black;
        color: white;
        padding: 3px 10px;
        border: none;
        margin-right: 1px; /* 신청 버튼의 오른쪽 마진을 10px로 설정 */
    }

    .button-container button.button-container-white {
        background-color: white;
        color: black;
        padding: 3px 10px;
        border: 1px solid black;
    }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="center-align">
    <form>
        <h1>CMS 사용자 신청현황</h1>
        <div class="form-container">
            <div class="table-container">
                <table>
                    <tr>
                        <td class="custom-cell">회원ID:</td>
                        <td><input type="text" class="input_text" id="user_id" value="" placeholder=""></td>
                    </tr>
                    <tr>
                        <td class="custom-cell">패스워드*</td>
                        <td><input type="password" class="input_text" id="user_pw" maxlength="10"></td>
                    </tr>
                    <tr>
                        <td class="custom-cell">이름*</td>
                        <td><input type="text" class="input_text" id="user_name" maxlength="10"></td>
                    </tr>
                    <tr>
                        <td class="custom-cell">휴대폰 번호*</td>
                        <td><input type="text" class="input_text" id="user_phone" maxlength="13"></td>
                    </tr>
                </table>
            </div>
            <div class="button-container">	
            	<button type="button" class="button-container-white" id="btn_exit">취소</button>
            </div>
        </div>
    </form>
</div>
 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    $(document).ready(function() {
        // URL에서 파라미터 값을 추출하는 함수
        function getURLParameter(name) {
            const urlParams = new URLSearchParams(window.location.search);
            return urlParams.get(name);
        }

        // URL에서 user_id, user_pw, user_name, user_phone 값을 추출
        var user_id = getURLParameter('user_id');
        var user_pw = getURLParameter('user_pw');
        var user_name = getURLParameter('user_name');
        var user_phone = getURLParameter('user_phone');

        // 추출한 값을 화면에 표시
        $("#user_id").val(user_id);
        $("#user_pw").val(user_pw);
        $("#user_name").val(user_name);
        $("#user_phone").val(user_phone);

        // user_id가 이미 들어있으면 수정할 수 없도록 설정
        if (user_id) {
            $("#user_id").attr("readonly", true);
        }
        if (user_pw){
        	 $("#user_pw").attr("readonly", true);
        } 
        if (user_name){
        	 $("#user_name").attr("readonly", true);
        } 
        if (user_phone){
        	 $("#user_phone").attr("readonly", true);
        }
    });
    
 	// 취소 버튼 클릭 시 로그인 페이지로 이동
    $("#btn_exit").off("click").on("click", function() {
        window.location.href = "http://localhost:8080/login";
    });
    </script>
</body>
</html>