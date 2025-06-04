package org.snack.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(session!=null){
            session.invalidate();
        }

        Cookie cookie=new Cookie("lastSnack","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        resp.sendRedirect("vote-form");
    }
}
