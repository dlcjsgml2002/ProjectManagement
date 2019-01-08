<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articleRead</title>
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
			<th>프로텍트 제목</th>
			<td>${name }</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${content }</td>
		</tr>
		<tr>
			<th>시작날짜</th>
			<td>${start }</td>
		</tr>
		<tr>
			<th>마감날짜</th>
			<td>${end }</td>
		</tr>
		<tr>
			<th>상태</th>
			<td>${progress }</td>
		</tr>
		
	</table>
	
	<a href="${pageContext.request.contextPath }/project/update.do?no=${no }">[수정]</a>
	<a href="${pageContext.request.contextPath }/project/delete.do?no=${no }">[삭제]</a>
	<a href="${pageContext.request.contextPath }/project/list.do">[돌아가기]</a>
</body>
</html>