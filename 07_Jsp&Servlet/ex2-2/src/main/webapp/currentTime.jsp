<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>스크립트릿 실습</title>
</head>
<body>
    <h1>현재 날짜 출력 실습</h1>
    <%
        Date d=new Date();
        Date d2=null;
    %>
    현재 날짜 : <%= d %>, <%=d2%>, <%=d3%>
</body>
</html>
