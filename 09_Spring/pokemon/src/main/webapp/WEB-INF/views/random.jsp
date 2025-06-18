<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>랜덤 포켓몬 뽑기</h1>
<h3>${pokemon.name}</h3>
<img src="${pokemon.sprites.frontDefault}">
<p>키: ${pokemon.height}</p>
<p>몸무게: ${pokemon.weight}</p>

<button value="다시 뽑기"></button>
</body>
</html>
