package cn.caoler.interceptor;

import cn.caoler.model.Admin;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * Author Caole
 * CreateDate: 2017/6/14
 * CreateTime: 11:15
 */
public class AdminInterceptor implements Interceptor{

    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        //通过客户端请求中的cookie的key获取cookie的value
        String cadmin = controller.getCookie("id");
        //在服务器端session中查找是否存在当前用户
        Admin admin = controller.getSessionAttr(cadmin);
        if (admin == null || inv.getMethodName().equals("login"))
            controller.redirect("/login/login.jsp");
        else {
            inv.invoke();
        }
    }
}
