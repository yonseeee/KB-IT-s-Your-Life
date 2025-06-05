package org.scoula.tacoyakki;

import org.scoula.tacoyakki.command.Command;
import org.scoula.tacoyakki.controller.HomeController;
import org.scoula.tacoyakki.controller.MenuController;
import org.scoula.tacoyakki.controller.OrderController;
import org.scoula.tacoyakki.controller.StatusController;
import org.scoula.tacoyakki.diapatcher.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name="frontControllerServlet", value="/")
public class FrontControllerServlet extends DispatcherServlet {
    HomeController homeController=new HomeController();
    MenuController menuController=new MenuController();
    OrderController orderController=new OrderController();
    StatusController  statusController=new StatusController();

    @Override
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

        getMap.put("/", homeController::getWelcome);
        getMap.put("/menu/list", menuController::getList);
        getMap.put("/menu/add", menuController::getAddForm);
        getMap.put("/order/new", orderController::getRandomMenu);
        getMap.put("/order/result",  orderController::getResult);
        getMap.put("/status", statusController::getStatus);

        postMap.put("/menu/add", menuController::postAdd);
        postMap.put("/order/confirm", orderController::postOrder);
    }
}
