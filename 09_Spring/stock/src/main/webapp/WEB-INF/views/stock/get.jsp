<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<%@include file="../layouts/header.jsp" %>


<h1 class="page-header my-4"><i class="far fa-file-alt"></i> ${stock.stockName}</h1>
<hr>
<div class="card m-1">
    <div class="card-body">
        <b>종목 코드: </b>${stock.stockCode}<br>
        <b>현재가: </b>${stock.price}<br>
        <b>등록일: </b><fmt:formatDate pattern="yyyy-MM-dd" value="${stock.regDate}"/><br>
        <b>설명: </b>${stock.description}<br>
    </div>

</div>
<div class="mt-4">
    <a href="list" class="btn btn-secondary">
        <i class="fas fa-list"></i> 목록
    </a>
    <a href="#" class="btn btn-success"><i class="fa-solid fa-cart-shopping"></i> 매수하기</a>
</div>


<%@include file="../layouts/footer.jsp" %>