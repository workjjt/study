<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  The Context Root is ${contextRoot}. </P>

<p>JSP 기본</p>
<ul>
	<li><a href="jsp/el">EL(Expression Language)</a></li>
	<li><a href="jsp/jstl">JSTL(Java Standard Tag Library)</a></li>
</ul>

<p>Spring Framework 예제 입니다.</p>
<ul>
	<li><a href="member">회원 가입 화면</a></li>
	<li><a href="daum/jsonp">jqgrid 예제- 다음 API를 사용(JSONP)</a></li>
	<li><a href="hr/list">jqgrid 예제- 오라클 HR 사용, JSON 데이터로 변환</a></li>
</ul>

</body>
</html>
