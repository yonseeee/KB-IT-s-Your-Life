package org.scoula.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String passwd = req.getParameter("passwd");

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        out.print("<html><body>");
        out.print("아이디값: " + userid + "<br>");
        out.print("비밀번호값: " + passwd + "<br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글 파라미터 깨짐 방지 (POST 요청 시 필수)
        req.setCharacterEncoding("utf-8");
        doGet(req, resp);
    }
}
