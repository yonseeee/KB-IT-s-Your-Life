package org.snack.controller;

import sun.jvm.hotspot.oops.CompressedOops;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/vote-form")
public class VoteFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("visitTime", new Date());
        Cookie[] c=req.getCookies();
        if(c!=null){
            for(Cookie cookie:c){
                if("lastSnack".equals(cookie.getName())){
                    req.setAttribute("lastSnack",cookie.getValue());
                    break;
                }
            }
        }
        RequestDispatcher dis=req.getRequestDispatcher("/vote_form.jsp");
        dis.forward(req,resp);
    }
}
