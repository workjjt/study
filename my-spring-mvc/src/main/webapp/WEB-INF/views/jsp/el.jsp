<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "전준태");
%>
<html>
<head>
<title>EL(Express Language)</title>
</head>
<body>
	<h1>EL(Express Language)</h1>

	<!-- 기본 객체 -->
	요청 URI : ${pageContext.request.requestURI}
	<br> request Name 속성 : ${requestScope.name}
	<br> code 파라메터 : ${requestScope.code}
	<br> code 파라메터 : ${code}
	<br>
	<!-- 기본 영역에서 차례대로 찾는다. -->

	<!-- 연산 -->
	숫자가 아닌 객체 : ${"12" + 3 }
	<br>
	<!-- 숫자로 변경후 계산, 숫자가 아닌경우 에러-->
	null 인 경우 : ${NULL + 5 }
	<br>
	<!-- null은 0으로 인식 -->
	비교 연산 : ${code == '안녕' }
	<br>

	<!-- 객체 접근 -->
	${member.setUsername('홍길동')} 멤버 이름 : ${member.getUsername() }
	<br> 멤버 이름 : ${member.username }
	<br>
</body>
</html>
