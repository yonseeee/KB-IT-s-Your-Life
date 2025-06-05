package org.scoula.tacoyakki.controller;

import org.scoula.tacoyakki.model.Menu;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class StatusController {
    public String getStatus(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext sc = req.getServletContext();
        List<Menu> menus= (List<Menu>) sc.getAttribute("menuList");
        int revenue=(Integer)sc.getAttribute("revenue");
        int inventory=(Integer)sc.getAttribute("inventory");
        Menu lastOrder=(Menu)sc.getAttribute("randomMenu");

        int size=menus.size();
        sc.setAttribute("size", size);

        return "status";
    }
}
