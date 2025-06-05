package org.scoula.tacoyakki.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
    public String getWelcome(HttpServletRequest req, HttpServletResponse resp) {
        return "welcome";
    }
}
