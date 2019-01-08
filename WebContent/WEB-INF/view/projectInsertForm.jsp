<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articleInsertForm</title>
<style>
	form {
		margin: 0 auto;
		width: 400px;
	}
	
	fieldset {
		padding-left: 20px;
	}
	
	label {
		display: block;
	}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/project/insert.do" method="post">
		<fieldset>
			<p>
				<label>프로젝트 이름</label>
				<input type="text" name="name" size="40">
			</p>
			<p>
				<label>프로젝트 내용</label>
				<textarea rows="10" cols="50" name="content"></textarea>
			</p>
			<p>
				<label>시작 날짜</label>
				<input type="text" name="start" size="40">
			</p>
			<p>
				<label>마감 날짜</label>
				<input type="text" name="end" size="40">
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
				<input type="submit" value="저장">
				<input type="reset" value="취소">
			</p>
		</fieldset>
	</form>
</body>
</html>