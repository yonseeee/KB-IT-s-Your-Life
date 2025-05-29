
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp"%>

    <form action="pastLifeResult.jsp" method="post">
        이름: <input type="text" name="username" required>

        <br><br>1. 어떤 색이 가장 끌리나요?<br>
        <input type="radio" name="q1" value="3"> 빨강
        <input type="radio" name="q1" value="2"> 파랑
        <input type="radio" name="q1" value="1"> 흰색
        <input type="radio" name="q1" value="0"> 검정

        <br><br>2. 비 오는 날 나는?<br>
        <input type="radio" name="q2" value="3"> 친구 만나러 나감
        <input type="radio" name="q2" value="2"> 책 읽음
        <input type="radio" name="q2" value="1"> 집콕
        <input type="radio" name="q2" value="0"> 그냥 잠

        <br><br>3. 여행 갈 때 나는?<br>
        <input type="radio" name="q3" value="3"> 짐 없이 출발
        <input type="radio" name="q3" value="2"> 계획 철저
        <input type="radio" name="q3" value="1"> 귀찮음
        <input type="radio" name="q3" value="0"> 안 감

        <br><br>4. 친구에게 듣는 말은?<br>
        <input type="radio" name="q4" value="3"> 재밌다
        <input type="radio" name="q4" value="2"> 똑똑하다
        <input type="radio" name="q4" value="1"> 조용하다
        <input type="radio" name="q4" value="0"> 이해불가

        <br><br>5. 늦잠 잤을 때 나는?<br>
        <input type="radio" name="q5" value="3"> 뛰어감
        <input type="radio" name="q5" value="2"> 핑계댐
        <input type="radio" name="q5" value="1"> 그냥 감
        <input type="radio" name="q5" value="0"> 결석함

        <br><br>6. 좋아하는 계절은?<br>
        <input type="radio" name="q6" value="3"> 여름
        <input type="radio" name="q6" value="2"> 봄
        <input type="radio" name="q6" value="1"> 가을
        <input type="radio" name="q6" value="0"> 겨울

        <br><br>7. 노래방에서 나는?<br>
        <input type="radio" name="q7" value="3"> 솔로곡 마스터
        <input type="radio" name="q7" value="2"> 떼창
        <input type="radio" name="q7" value="1"> 관전
        <input type="radio" name="q7" value="0"> 안 감

        <br><br>8. 맛집 줄 서야 할 때 나는?<br>
        <input type="radio" name="q8" value="3"> 기다림
        <input type="radio" name="q8" value="2"> 다른 집 탐색
        <input type="radio" name="q8" value="1"> 짜증남
        <input type="radio" name="q8" value="0"> 포기함

        <br><br>9. 선택 앞에서 나는?<br>
        <input type="radio" name="q9" value="3"> 빠르게 결정
        <input type="radio" name="q9" value="2"> 심사숙고
        <input type="radio" name="q9" value="1"> 남에게 맡김
        <input type="radio" name="q9" value="0"> 못 고름

        <br><br>10. 원하는 삶은?<br>
        <input type="radio" name="q10" value="3"> 모험가
        <input type="radio" name="q10" value="2"> 안정형
        <input type="radio" name="q10" value="1"> 예술가
        <input type="radio" name="q10" value="0"> 은둔자

        <br><br>11. 갑자기 1억 생기면?<br>
        <input type="radio" name="q11" value="3"> 창업
        <input type="radio" name="q11" value="2"> 해외여행
        <input type="radio" name="q11" value="1"> 집에서 쉼
        <input type="radio" name="q11" value="0"> 혼란

        <br><br>12. 가끔 드는 생각은?<br>
        <input type="radio" name="q12" value="3"> 나는 누굴까
        <input type="radio" name="q12" value="2"> 전생이 뭐였을까
        <input type="radio" name="q12" value="1"> 그냥 산다
        <input type="radio" name="q12" value="0"> 아무 생각 없음
        <br><br>
        <input type="submit" value="전생 보러 가기 💫">
    </form>
<%@ include file="footer.jsp"%>
</body>
</html>
