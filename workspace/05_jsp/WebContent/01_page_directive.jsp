<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"
    	 errorPage="error.jsp"
    	 isErrorPage="true" 
    	  %>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//자바코드
	ArrayList list = new ArrayList();
	Date d = new Date();
	String n = null;
	System.out.println(n.length()); //NullPointException 발생 => errorPage에 지정한 화면으로 넘어감

%>
안녕하세요.
</body>
</html>