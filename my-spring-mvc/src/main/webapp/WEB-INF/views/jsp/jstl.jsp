<%@page import="com.mycompany.mvc.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
	Member m  = (Member)request.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 예제</h1>

<h3>[EL 변수 설정]</h3>
<c:set var="name1" value="전준태"/>
<c:set var="name2">전준태</c:set>
<c:set var="username1" value="<%= m.getUsername() %>" />
<c:set var="username2" value="${member.username}" />
${name1}<br>
${name2}<br>
${username1}<br>
${username2}<br>

<h3>객체의 프로퍼티</h3>
<c:set target="<%= m %>" property="username" value="최범균1" />
${member.getUsername() }<br>
<c:set target="${member }" property="username" value="최범균2" />
${member.getUsername() }<br>

<h3>[흐름 제어]</h3>
<h4>조건문</h4>
<c:if test="true">무조건 실행</c:if><br>
<c:set var="var1" value="false"/>
${var1 }<br>
<c:if test="${member.username == '최범균2' }" var="var1">username은 ${member.username }  이다</c:if><br>
${var1 }

<c:choose>
	<c:when test="false">실핼 안됨</c:when>
	<c:when test="true">무조건 실행</c:when>
	<c:otherwise>둘다 실행 안되면 실행</c:otherwise>
</c:choose>
<h4>반목문</h4>
<c:set var="array" value="<%= new int[] {1,2,3,4,5,6,7} %>" />
<c:forEach var="i" items="${array}" varStatus="status">
	${status.index} : ${i}<br>
</c:forEach>

<h4>map 객체 출력</h4>
<c:forEach var="item" items="${hashMap }">
	${item.key } : ${item.value }<br>
</c:forEach>
<br>
<h4>List 객체 출력</h4>
<c:forEach var="item" items="${arrayList }">
	${item }<br>
</c:forEach>

</body>
</html>