<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
	<title>스퀘어네트</title>
	<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	ul li{
		list-style: none;
	}
	a {
		text-decoration: none;
		color:#333;
	}

	#menu {
		font:bold 16px "malgun gothic";
		width:700px;
		height:50px;
		background: #ccc;
		color:black;
		line-height: 50px; 
		margin:0 auto;
		text-align: center;
	}

	#menu > ul > li {
		float:left;
		width:140px;
		position:relative;
	}
	#menu > ul > li > ul {
		width:130px;
		display:none;
		position: absolute;
		font-size:14px;
		background: skyblue;
	}
	#menu > ul > li:hover > ul {
		display:block;
		
	}
	#menu > ul > li > ul > li:hover {
		background: orange;
		transition: ease 1s;
		}
	</style>
</head>
<body>
	<div id="menu">
	<ul>
		<li><a href="#">MENU1</a>
			<ul>
				<li><a href="#">SUB_MENU</a></li>
				<li><a href="#">SUB_MENU2</a></li>
				<li><a href="#">SUB_MENU3</a></li>
			</ul>
		</li>
		<li><a href="#">MENU2</a>
			<ul>
				<li><a href="#">SUB_MENU</a></li>
				<li><a href="#">SUB_MENU2</a></li>
				<li><a href="#">SUB_MENU3</a></li>
			</ul>
		</li>
		<li><a href="#">MENU3</a>
			<ul>
				<li><a href="#">SUB_MENU</a></li>
				<li><a href="#">SUB_MENU2</a></li>
				<li><a href="#">SUB_MENU3</a></li>
			</ul>
		</li>
		<li><a href="#">MENU4</a>
			<ul>
				<li><a href="#">SUB_MENU</a></li>
				<li><a href="#">SUB_MENU2</a></li>
				<li><a href="#">SUB_MENU3</a></li>
			</ul>
		</li>
		<li><a href="#">MENU5</a>
			<ul>
				<li><a href="#">SUB_MENU</a></li>
				<li><a href="#">SUB_MENU2</a></li>
				<li><a href="#">SUB_MENU3</a></li>
			</ul>
		</li>
	</ul>
</div>
</body>
</html>
