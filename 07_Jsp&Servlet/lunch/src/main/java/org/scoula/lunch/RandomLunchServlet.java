package org.scoula.lunch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/lunch/random")
public class RandomLunchServlet extends HttpServlet {
    static Map<String, int[]>map=new HashMap<>();
    static String[]menus={"쭈꾸미볶음","김치찌개","크림파스타","부대찌개","햄버거","제육볶음"};
    static{
        for(String m:menus){
            map.put(m, new int[]{0,0});
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        String menu=req.getParameter("menu");
        String vote=req.getParameter("vote");

        int index=(int)Math.floor(Math.random()*6);
        String menuName=menus[index];

        out.println("<html><body>");

        if (menu == null && vote == null) {
            out.println("<h1> 오늘의 점심 메뉴 추천 🍴</h1>");
            out.println("<b><p>"+menuName+"</p></b>");

            out.println("<form action=\"random\" method=\"get\">");
            out.println("<input type=\"hidden\" name=\"menu\" value=\"" + menuName + "\">");

            out.println("<button type=\"submit\" name=\"vote\" value=\"like\">👍 좋아요</button>");
            out.println("<button type=\"submit\" name=\"vote\" value=\"dislike\">👎 싫어요</button>");

            out.println("</form>");


        }else{
            vote=req.getParameter("vote");
            int like=map.get(menuName)[0];
            int dislike=map.get(menuName)[1];
            if(vote.equals("like")){
                like++;
            }else{dislike++;}

            map.put(menuName, new int[]{like,dislike});
            out.println("<h1>🍽 \'"+menu+"\' 메뉴에 대한 투표 결과</h1>");
            out.println("<p> 👍 좋아요: "+map.get(menuName)[0]+"</p>");
            out.println("<p> 👍 싫어요: "+map.get(menuName)[1]+"</p>");
            out.println("<a href=\"" + req.getContextPath() + "/lunch/random\"><-다시 선택하기</a>");
        }
        out.println("</html></body>");
    }
}
