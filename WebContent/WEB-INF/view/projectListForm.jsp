<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ArticleListForm</title>
<style>
	table {
		border-collapse: collapse;
	}
	
	th, td {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th colspan="4"><a href="${pageContext.request.contextPath }/project/insert.do">[게시글 쓰기]</a></th>
		</tr>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>상태</th>
		</tr>
		<c:forEach var="project" items="${list }">
			<tr>
				<td><a href="${pageContext.request.contextPath }/project/read.do?no=${project.serial_number }">${project.project_name }</a></td>
				<td>${project.start_date }</td>
				<td>${project.end_date }</td>
				<td>${project.project_progress }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>