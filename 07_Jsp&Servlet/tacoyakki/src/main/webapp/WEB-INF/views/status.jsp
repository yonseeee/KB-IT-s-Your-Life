<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>📊 가게 현황</h1>
<li> 💸 누적 매출: ${revenue}원</li>
<li> 📦 남은 재고: ${inventory}</li>
<li> 📋 등록된 메뉴 수: ${size} </li>

<c:if test="${randomMenu!=null}">
    <li>
        📃 마지막 주문: "${randomMenu.name}"- ${randomMenu.price}원 (성공)
    </li>
</c:if>


<hr>
<a href="/">🏠 돌아가기</a>
<a href="/order/new"> 🙎 다음 손님 받기</a>
</body>
</html>
