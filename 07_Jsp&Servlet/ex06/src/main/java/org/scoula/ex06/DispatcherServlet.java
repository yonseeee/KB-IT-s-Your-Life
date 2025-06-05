package org.scoula.ex06;

import org.scoula.ex06.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//어노테이션은 상속되지 않기 때문에 부모클래스에 안 붙임
public class DispatcherServlet extends HttpServlet {
//    GET 방식 요청 처리용 커맨드 맵
    Map<String, Command> getMap;
//    OST 방식 요청 처리용 커맨드 맵
    Map<String,Command> postMap;

    String prefix="/views/";
    String suffix=".jsp";

    public void init(){
//        각 맵 초기화
        getMap=new HashMap<>();
        postMap=new HashMap<>();
        createMap(getMap, postMap);
    }
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap){
//        자식이 결정
    }

    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest req) {
        String commandName = getCommandName(req);
        Command command;
        if (req.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }
        return command;
    }

    public void execute(Command command, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        커맨드 실행 -> 반환된 뷰 이름(view 경로)를 통해 포워딩 가능
        String viewName = command.execute(req, resp);
        if (viewName.startsWith("redirect:")) {
            // redirect 처리, "redirect:" 접두사 제거하고 클라이언트에 재요청
            resp.sendRedirect(viewName.substring("redirect:".length()));
        } else {    // forward 처리, 뷰 이름을 실제 JSP 경로로 조합
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = getCommand(req);
        if (command != null) {
            execute(command, req, resp);
        } else { // 404 에러 처리
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
