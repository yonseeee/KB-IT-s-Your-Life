<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 25. 6. 4.
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${lastSnack!=null}"><b>최근에 고른 간식: ${lastSnack}
    </b><br>
        <i>이 간식을 다시 드셔보는 건 어떠세요?</i> <br>
    </c:if>
    <c:if test="${visitTime!=null}">최근 방문 시간: ${visitTime}</c:if>
    <h1>🍩 우리 반 인기 간식 투표</h1>
    <form action="/vote-submit" method="post">
        <fieldset>
            <legend>좋아하는 간식을 하나 골라주세요</legend>
            <input type="radio" name="snack" value="와사비과자"> 와사비과자<br>
            <input type="radio" name="snack" value="붕어빵"> 붕어빵<br>
            <input type="radio" name="snack" value="쿠쉬쿠쉬"> 쿠쉬쿠쉬<br>
            <input type="radio" name="snack" value="초코하임"> 초코하임<br>
            <input type="radio" name="snack" value="몽쉘"> 몽쉘<br>
            <input type="radio" name="snack" value="커스타드"> 커스타드<br>
            <input type="radio" name="snack" value="쿠크다스"> 쿠크다스<br>
            <input type="radio" name="snack" value="초코파이"> 초코파이<br>
            <input type="radio" name="snack" value="꿀꽈배기"> 꿀꽈배기<br><br>
            <input type="submit" value="투표하기">
        </fieldset>
    </form>
    <form action="reset" method="get">
        <button type="submit">초기화</button>
    </form>
</body>
</html>
