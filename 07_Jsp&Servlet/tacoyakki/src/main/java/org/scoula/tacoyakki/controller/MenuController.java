package org.scoula.tacoyakki.controller;

import org.scoula.tacoyakki.model.Menu;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuController {
    public String getList(HttpServletRequest req, HttpServletResponse resp) {
//        List<String> list= Arrays.asList("🐙 오리지널 타코야끼","🧀 치즈 타코야끼");
//        req.setAttribute("tacoList",list);
        return "menu/list";
    }
    public String getAddForm(HttpServletRequest req, HttpServletResponse resp) {
        return "menu/add";
    }
    public String postAdd(HttpServletRequest req, HttpServletResponse resp) {
        String menu=req.getParameter("menu");
        int price=Integer.parseInt(req.getParameter("price"));
        Menu m=new Menu();
        m.setName(menu);
        m.setPrice(price);

        ServletContext sc=req.getServletContext();

        List<Menu> list= (List<Menu>) sc.getAttribute("menuList");
        if(list==null) {
            list = new ArrayList<Menu>();
        }
        list.add(m);
        sc.setAttribute("menuList",list);
//        req.setAttribute("tacoList",list);

        return "redirect:list";
    }
}
