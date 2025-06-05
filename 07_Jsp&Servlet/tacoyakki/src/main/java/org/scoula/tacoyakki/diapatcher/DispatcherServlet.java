package org.scoula.tacoyakki.diapatcher;

import org.scoula.tacoyakki.command.Command;
import org.scoula.tacoyakki.model.Menu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap;
    Map<String,Command> postMap;

    String prefix="/WEB-INF/views/";
    String suffix=".jsp";

    @Override
    public void init() throws ServletException {
        getMap=new HashMap<>();
        postMap=new HashMap<>();
        createMap(getMap,postMap);


        ServletContext ctx = getServletContext();

        if (ctx.getAttribute("menuList") == null) {
            List<Menu> menuList = new ArrayList<>();
            menuList.add(new Menu("오리지널 타코야끼", 3000));
            menuList.add(new Menu("치즈 타코야끼", 3500));
            menuList.add(new Menu("불닭 타코야끼", 4000));
            menuList.add(new Menu("와사비 타코야끼", 3800));
            menuList.add(new Menu("날치알 타코야끼", 4200));
            menuList.add(new Menu("옥수수콘 타코야끼", 3700));
            menuList.add(new Menu("문어풀장 타코야끼", 4500));
            menuList.add(new Menu("고르곤졸라 타코야끼", 4800));
            menuList.add(new Menu("트러플오일 타코야끼", 5200));
            menuList.add(new Menu("초코소스 타코야끼 (디저트)", 3900));
            ctx.setAttribute("menuList", menuList);
        }

        if (ctx.getAttribute("inventory") == null) {
            ctx.setAttribute("inventory", 5);
        }
        if (ctx.getAttribute("revenue") == null) {
            ctx.setAttribute("revenue", 0);
        }
    }
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap){
//        자식이 결정
    }
    private String getCommandName(HttpServletRequest req){
        String requestURI=req.getRequestURI();
        String contextPath=req.getContextPath();
        return requestURI.substring(contextPath.length());
    }
    private Command getCommand(HttpServletRequest req){
        String commandName=getCommandName(req);
        System.out.println("commandName:"+commandName);
        Command command;
        if(req.getMethod().equalsIgnoreCase("GET")){
            command=getMap.get(commandName);
        }else{
            command=postMap.get(commandName);
        }
        return command;
    }
    public void execute(Command command, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String viewName=command.execute(req,resp);
        if(viewName.startsWith("redirect:")){
            resp.sendRedirect(viewName.substring("redirect:".length()));
        }else{
            String view=prefix+viewName+suffix;
            RequestDispatcher dis=req.getRequestDispatcher(view);
            dis.forward(req,resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command=getCommand(req);

        if(command!=null){
            execute(command, req, resp);
        }else{
            String view=prefix+"404"+suffix;
            RequestDispatcher dis=req.getRequestDispatcher(view);
            dis.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req,resp);
    }
}
