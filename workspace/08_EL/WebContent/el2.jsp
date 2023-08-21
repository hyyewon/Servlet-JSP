<%@page import="java.util.List"%>
<%@page import="com.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>scope에 저장된 값 출력</h1>
<h2>1. 이전 방식</h2>
<%
String userid = (String)request.getAttribute("userid");
String xxx = (String)request.getAttribute("xxx"); //setAttribute 하지 않은 값

String userid2 = (String)session.getAttribute("userid");
String userid3 = (String)application.getAttribute("userid");

//DTO얻기
LoginDTO dto = (LoginDTO)request.getAttribute("login");

//list얻기
List<LoginDTO> list = (List<LoginDTO>)request.getAttribute("list");

%>
이름:<%=userid %><br>
null값:<%=xxx %><br>
null여부:<%=xxx==null %><br>
request:<%=userid %><br>
session:<%=userid2 %><br>
application:<%=userid3 %><br>
아이디:<%=dto.getUserid() %><br>
비밀번호:<%=dto.getPasswd() %><br>
list:<%=list.get(0).getUserid() %><%=list.get(0).getPasswd() %><br>
list:<%=list.get(1).getUserid() %><%=list.get(1).getPasswd() %><br>


<h2>2. EL 방식</h2>
<%
	String kkk="이순신"; //EL로 출력 불가. 반드시 scope에 저장된 값만 출력 가능
%>
이름:${userid}<br> <!-- scope에 저장된 key값 -->
이름:${kkk}<br> <!-- 이렇게는 사용 못함. 사용할 수 있는 값 : 1.실제값 2.setAttribute한 값-->
null값:${xxx}<br> <!-- null값을 비어있는 값으로 처리 -->
null여부:${empty xxx}<br>
request:${userid}<br>
session:${sessionScope.userid}<br> <!-- sessionScope -->
application:${applicationScope.userid}<br> <!-- applicationScope -->
아이디:${login.userid }<br> <!-- 'key값.변수이름' 으로 출력 -->
비밀번호:${login.passwd }<br>
list1:${list[0].userid }${list[0].passwd }<br> <!-- 'key값[인덱스].변수이름' 으로 출력 -->
list2:${list[1].userid }${list[1].passwd }<br>
</body>
</html>
