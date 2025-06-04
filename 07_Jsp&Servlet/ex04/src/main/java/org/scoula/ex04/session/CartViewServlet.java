package org.scoula.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter(); // 입력파라미터얻기
        out.print("<html><body>");
        out.print("장바구니 리스트");

        HttpSession session = req.getSession(false);
        session.setMaxInactiveInterval(20);


        if (session != null) {
            ArrayList<String> list=(ArrayList<String>) session.getAttribute("product");
            out.print("상품: "+list+"<br>");

        }else{
            out.print("세션 없음 ="+"<br>");
        }

        out.print("<a href='session_product.jsp'>상품선택페이지</a><br>");
        out.print("<a href='cart_delete'>장바구니 비우기</a>");
        out.print("</body></html>");
    }
}