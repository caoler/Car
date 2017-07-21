package cn.caoler.controller;


import cn.caoler.interceptor.AdminInterceptor;
import cn.caoler.model.Car;
import cn.caoler.model.Ticket;
import cn.caoler.model.Wiring;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * Author Caole
 * CreateDate: 2017/6/1
 * CreateTime: 15:42
 */
@Before(AdminInterceptor.class)
public class AdminController extends Controller{
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
    public void UpdateTicket(){
        Integer price = getParaToInt("price");
        if (price != null && price > 0) {
            setAttr("admin", Ticket.me.findById(price));
        }
        render("form.jsp");
    }
    public void save() {
        Ticket ticket = getModel(Ticket.class,"admin");
        Integer price =  ticket.get("price");
        if (Ticket.me.findById(price) == null) {
            ticket.save();
        } else if (ticket.getInt("price") > 0){
            ticket.update();
        }
        QueryTicket();
    }
    public void UpdateCar() {
        String class1 = getPara("class");
        if (class1 != null) {
            setAttr("admin", Car.me.findById(class1));
        }
        render("c-form.jsp");
    }
    public void saveCar(){
        Car car = getModel(Car.class);
        String class1 = car.get("class");
        if (Car.me.findById(class1) == null) {
            car.save();
        } else {
            car.update();
        }
        QueryCar();
    }
    public void UpdateWiring() {
        String start = getPara("start");
        if (start != null) {
            setAttr("admin", Wiring.me.findById(start));
        }
        render("w-form.jsp");
    }
    public void saveWiring(){
        Wiring wiring = getModel(Wiring.class);
        String start = wiring.get("start");
        if (Wiring.me.findById(start) == null) {
            wiring.save();
        } else {
            wiring.update();
        }
        QueryWiring();
    }
}
