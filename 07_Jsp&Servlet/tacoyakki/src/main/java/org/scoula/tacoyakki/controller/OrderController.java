package org.scoula.tacoyakki.controller;

import org.scoula.tacoyakki.model.Menu;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderController {
    public String getRandomMenu(HttpServletRequest req, HttpServletResponse resp){
        ServletContext sc = req.getServletContext();
        List<Menu> list = (List<Menu>)sc.getAttribute("menuList");
        int idx= (int)(Math.random()*list.size());
        sc.setAttribute("randomMenu", list.get(idx));
        return "order/new";
    }
    public String postOrder(HttpServletRequest req, HttpServletResponse resp){
        ServletContext sc = req.getServletContext();
        Menu menu= (Menu) sc.getAttribute("randomMenu");
        int inventory=(Integer)sc.getAttribute("inventory");
        int revenue=(Integer)sc.getAttribute("revenue");

        if(inventory>=1){
            revenue+=menu.getPrice();
            inventory-=1;
            sc.setAttribute("isSuccess",true);
            sc.setAttribute("inventory",inventory);
            sc.setAttribute("revenue",revenue);
        }
        else{
            sc.setAttribute("isSuccess",false);
        }

        return "redirect:/order/result";
    }
    public String getResult(HttpServletRequest req, HttpServletResponse resp){
        return "order/result";
    }
}
