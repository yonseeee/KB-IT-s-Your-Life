package org.scoula.lunch;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lunch")
public class LunchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        // Hello
        PrintWriter out = resp.getWriter();

        String mood=req.getParameter("mood");
        out.println("<html><body>");
        if(mood==null){

            out.println("<h1>" + "오늘 기분은 어떤가요?" + "</h1>");
            out.println("<form action=\"lunch\" method=\"get\">");
            out.println("<select name=\"mood\">");
            out.println("<option value=\"soso\">그냥 그래</option>");
            out.println("<option value=\"happy\">기분 최고야</option>");
            out.println("<option value=\"sad\">우울해</option>");
            out.println("<option value=\"stressed\">스트레스 쩔어</option>");
            out.println("<option value=\"etc\">기타</option>");
            out.println("</select>");
            out.println("</br></br>");
            out.println("<input type=\"submit\" value=\"추천 받기\">");
            out.println("</form>");

        }else{
            out.println("<h1>" + "오늘의 추천 메뉴 🍽" + "</h1>");
            String result="";
            if(mood.equals("happy"))result="매콤한 쭈꾸미볶음 추천!";
            else if(mood.equals("soso"))result="든든한 김치찌개 어떠세요?";
            else if(mood.equals("sad"))result="부드러운 크림파스타로 위로받으세요.";
            else if(mood.equals("stressed"))result="부대찌개 한 냄비 추천드려요!";
            else result="오늘은 도시락도 괜찮아요!";

            out.println("<p>"+result+"</p>");

            out.println("<a href=\"" + req.getContextPath() + "/lunch\"><-다시 선택하기</a>");

        }
        out.println("</body></html>");
    }
}
