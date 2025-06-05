<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> 주문 결과 </h1>
    <c:if test="${isSuccess==true}">
        🎉 ${randomMenu.name} 주문 성공! <br>
        💸 누적 매출: ${revenue}원<br>
        📦 남은 재고: ${inventory}<br>
    </c:if>
    <c:if test="${isSuccess==false}">
        ❌ 주문 실패! 재고가 부족합니다. <br>
        📦 남은 재고: ${inventory}<br>
    </c:if>

    <a href="/order/new">🙎‍♀️ 다음 손님 받기</a> <br>
    <a href="/">🏠 돌아가기</a>

</body>
</html>
