<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp"%>
<body>

<%!int count;%>
    <%
        int sum=0;
        boolean flag=true;
        String mine="";
        String another="";
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        session.setAttribute("username", username);

        for(int i=1;i<=12;i++){
            String answer="q"+i;
            String result=request.getParameter(answer);
            if(result==null){
                flag=false;
                break;
            }
            else{
                int score=Integer.parseInt(request.getParameter(answer));
                sum+=score;
            }
        }
        if(flag){
            count++;
            application.setAttribute("countValue", count);
            if(sum>=0&&sum<=3){
                mine="굶주린 동굴 두더지";
                another="신비한 고양이 주술사";
            }else if(sum<=7){
                mine="도서관의 유령";
                another="구중의 무희";
            }else if(sum<=11){
                mine="숲속 명상 수도승";
                another="야시장 상인";
            }else if(sum<=15){
                mine="사막의 낙타 상인";
                another="오아시스 정령";
            }else if(sum<=19){
                mine="고대 마법사";
                another="용맹한 기사";
            }else if(sum<=23){
                mine="궁전의 비밀 요원";
                another="황제의 고문관";
            }else if(sum<=27){
                mine="시간여행자";
                another="예언자";
            }else if(sum<=30){
                mine="별을 읽는 점성술사";
                another="구름 위의 수도자";
            }else if(sum<=33){
                mine="천상의 존재";
                another="혼돈의 악마왕";
            }else{
                mine="잃어버린 차원의 군주";
                another="세계수의 수호자";
            }
        }
    %>

<% if (flag) { %>
    <h1>✨ <%=username%>님의 전생 심리 테스트 결과 ✨</h1>
    <hr>
    <h3>📜 전생 기록 검색 결과...</h3>
    🧠 당신의 심리 점수는 <b><%=sum%></b>점입니다.
    <br>
    🧍‍♀️ 지금까지 <b><%=count%></b>명의 전생이 분석되었습니다.

    <h3>🔮 당신의 전생은...</h3>
    <b><%=mine%></b>입니다!
    <h3>💘 당신과 궁합이 잘 맞는 전생 캐릭터는...</h3>
    <b><%=another%></b>입니다!
<% } else { %>
    <h1>🚫 전생 분석 실패</h1>
    모든 문항을 선택해야 전생 분석이 가능합니다. <br>
    <a href="pastLifeTest.jsp">🔄 다시 테스트하러 가기</a>
<% }%>
</body>
<%@ include file="footer.jsp"%>
</html>
