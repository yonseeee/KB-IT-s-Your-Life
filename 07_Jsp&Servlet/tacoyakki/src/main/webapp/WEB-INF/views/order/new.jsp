<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>👩 손님이 주문하러 왔어요!</h1>
    📝 "${randomMenu.name}" (가격: ${randomMenu.price}원)를 주문합니다.
    <br>
    <form action="/order/confirm" method="post">
        <input type="submit" value="주문 확정">
    </form>

    <a href="/">🏠 돌아가기</a>
</body>
</html>
