<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<%@include file="../layouts/header.jsp" %>
<%-- 개별페이지--%>
<h1 class="page-header my-4"><i class="fa-solid fa-arrow-trend-up"></i>주식 목록</h1>
<hr>
<table class="table table-hover">
    <thead>
    <tr>
        <th>No</th>
        <th>종목 코드</th>
        <th>종목 이름</th>
        <th>현재가</th>
        <th>등록일</th>
    </tr>
    </thead>
    <tbody><c:forEach var="stock" items="${list}">
        <tr>
            <td>${stock.no}</td>
            <td>${stock.stockCode}</td>
            <td>
                <a href="get?no=${stock.no}">${stock.stockName}</a></td>
            <td>${stock.price}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${stock.regDate}"/></td>
        </tr>
    </c:forEach></tbody>
</table>

<div class="text-end">
    <%--    상대경로이기 때문에 board/list로 간다--%>
    <a href="create" class="btn btn-primary">
        <i class="fa-solid fa-plus"></i>
        새 종목 등록
    </a>
</div>
<%@include file="../layouts/footer.jsp" %>