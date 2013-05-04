<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
	body{
		font-family: Arial, Verdana, sans-serif;
		padding: 10px;
	}
	h1, h2{
		color: #ee3e30;
	}
	</style>
</head>
<body>
<h1>Spring Example & SmartEditor Test!</h1>

<div>
	<ul>
		<li>ModelAttribute Text is ${modelText}.</li>
		<li>The time on the server is ${serverTime}. </li>
	</ul>
</div>
<div>
	<ul>
		<li><a href="./member/login">로그인 & interceptor 사용 예제</a></li>
		<li><a href="./smarteditor">SmartEditor & ibatis 사용 예제</a></li>
		<li><a href="#">Twitter Bootstrap 예제</a></li>
	</ul>
</div>

</body>
</html>
