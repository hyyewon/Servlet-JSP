<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서입력</h2>
//현재: http://localhost:8090/03_servlet/deptForm.jsp
//타겟: http://localhost:8090/03_servlet/write
<form action="write" method="post"><!-- 상대경로로 action 지정, DB가 바뀔 여지가 있으면 post로 반환 받아야 함 -->
부서번호:<input type="text" name="deptno"><br>
부서명:<input type="text" name="dname"><br>
부서위치:<input type="text" name="loc"><br>
<input type="submit" value="저장">
<p><a href='list'>목록보기</a></p>
</form>
</body>
</html>