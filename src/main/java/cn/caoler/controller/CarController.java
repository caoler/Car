package cn.caoler.controller;

import cn.caoler.interceptor.UserInterceptor;
import cn.caoler.model.Ticket;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * Author Caole
 * CreateDate: 2017/6/1
 * CreateTime: 14:14
 */
@Before(UserInterceptor.class)
public class CarController extends Controller{
    public void index(){
        render("index.jsp");
    }
    public void QueryWiring(){
        setAttr("wiring", Ticket.me.find("SELECT * FROM t_wiring"));
        render("wiring.jsp");
    }
    public void QueryCar(){
        setAttr("car", Ticket.me.find("SELECT * FROM t_car"));
        render("car.jsp");
    }
    public void QueryTicket(){
        setAttr("ticket", Ticket.me.find("SELECT * FROM t_ticket"));
        render("ticket.jsp");
    }
}
