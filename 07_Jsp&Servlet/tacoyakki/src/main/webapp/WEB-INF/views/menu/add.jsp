<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>🧂 새 타코야끼 메뉴 추가</h1>
    <form action="/menu/add" method="post">
        이름: <input type="text" name="menu"><br>
        가격: <input type="text" name="price"><br>
        <input type="submit" value="추가">
        <br>
        <a href="/menu/list"><- 메뉴판으로 돌아가기</a>
    </form>


</body>
</html>
