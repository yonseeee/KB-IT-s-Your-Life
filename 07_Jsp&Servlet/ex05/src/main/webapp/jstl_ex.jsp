<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 6. 4.
  Time: 오후 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSTL 테스트</h1>

    <c:if test="${role=='ADMIN'}">관리자</c:if>
    <c:if test="${role!='ADMIN'}">일반회원</c:if>

    <table>
        <c:forEach var="member" items="${members}" varStatus="state">
            <tr>
                <td>${state.index}</td>
                <td>${member.name}</td>
                <td>${member.userid}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    ${today}<br>

<%--    기본 날짜 형식 출력--%>
    <fmt:formatDate value="${today}" type="date"/><br>
    <fmt:formatDate value="${today}" type="time"/><br>
    <fmt:formatDate value="${today}" type="both"/><br>

<%--    dateStyle과 timeStyle 조합 출력--%>
    <fmt:formatDate value="${today}" type="date" dateStyle="short" timeStyle="long"/><br>
    <fmt:formatDate value="${today}" type="date" dateStyle="long" timeStyle="short"/><br>

<%--    커스텀 포맷 사용 (패턴 지정)--%>
    <fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss"/><br>
    <fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm:ss"/><br>
</body>
</html>
