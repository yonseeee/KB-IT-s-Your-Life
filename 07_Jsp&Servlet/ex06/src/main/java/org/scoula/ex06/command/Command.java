package org.scoula.ex06.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
//    처리 후 이동할 뷰 페이지 경로(String)를 반환
    String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
