<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Home</title>
<style type="text/css">
table {
	width: 800px; table-layout : fixed;
	margin: 0;
	padding: 0;
	line-height: 21px;
	border-top: 1px solid #cccccc;
	border-left: 1px solid #cccccc;
	border-collapse: collapse;
	table-layout: fixed;
}

th,td {
	margin: 0;
	padding: 3px 0;
	text-align: left;
	border-right: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
	text-overflow: ellipsis;
	overflow: hidden;
}

th {
	text-align: center; text-transform : uppercase;
	background-color: #e9e9e9;
	text-transform: uppercase;
}

.num {
	width: 50px;
	text-align: center;
}
</style>
</head>
<body>
	<h1>SmartEditor 예제!</h1>
	<hr>
	<%@ include file="/resources/smarteditor231/SmartEditor2.html" %>
	<hr>
	<h4>
		리스트 내용(갯수 : ${contents.size()} )
		</h2>
		<table>
			<thead>
				<tr>
					<th class="num">번호</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contents}" var="contents" varStatus="status">
					<tr>
						<td class="num">${status.count }</td>
						<td><nobr>${contents.content }</nobr></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>
