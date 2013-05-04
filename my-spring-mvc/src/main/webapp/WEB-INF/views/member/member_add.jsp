<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>회원 가입</title>
</head>
<body>
	<form action="${contextRoot}/member/add" method="post">
		<table>
			<tbody>
				<tr>
					<th>사용자 이름</th>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" /><input type="button"
						onclick="" value="중복확인" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="password1" /></td>
				</tr>
				<tr>
					<th>비밀확인</th>
					<td><input type="text" name="password2" /></td>
				</tr>
				<tr>
					<th>이메일 주소</th>
					<td><input type="text" name="mail1" />@<input type="text"
						id="mail2" /></td>
				</tr>
				<tr>
					<th>전화번호(휴대폰 번호)</th>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<th>관심 분야</th>
					<td><input type="checkbox" name="arrChk" value="01">컴퓨터
						<input type="checkbox" name="arrChk" value="02">운동 
						<input type="checkbox" name="arrChk" value="03">미술</td>
				</tr>
				<tr>
					<th>국가</th>
					<td><select id="country" name="country">
							<option value="US">United Stated</option>
							<option value="CHINA">China</option>
							<option value="SG">Singapore</option>
							<option value="MY">Malaysia</option>
					</select></td>
				</tr>
				<tr>
					<th>운동 종목</th>
					<td><select id="hobby" name="hobby" multiple="multiple">
							<option value="fishing">fishing</option>
							<option value="football">football</option>
							<option value="riding">riding</option>
							<option value="criming">criming</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="전송" /></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>
