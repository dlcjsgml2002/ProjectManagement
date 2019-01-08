<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/project/update.do?no=${project.serial_number}" method="post">
		<fieldset>
			<p>
				<label>프로젝트 이름</label>
				<input type="text" name="name" value="${project.project_name}"size="40">
			</p>
			<p>
				<label>프로젝트 내용</label>
				<textarea rows="10" cols="50" name="content">${project.project_content }</textarea>
			</p>
			<p>
				<label>시작 날짜</label>
				<input type="text" name="start" value="${project.start_date }"size="40">
			</p>
			<p>
				<label>마감 날짜</label>
				<input type="text" name="end" value="${project.end_date}"size="40">
			</p>
			<p>
				<label>상태</label>
				<select name="progress">
					<option value="준비">준비</option>
					<option value="진행중">진행중</option>
					<option value="종료">종료</option>
					<option value="보류">보류</option>
				</select>
			</p>
			<p>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</p>
		</fieldset>
	</form>
</body>
</html>