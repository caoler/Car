package cn.caoler.interceptor;

import cn.caoler.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

/**
 * Author Caole
 * CreateDate: 2017/6/14
 * CreateTime: 16:07
 */
public class UserInterceptor implements Interceptor{

    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        //通过客户端请求中的cookie的key获取cookie的value
        String cuser = controller.getCookie("id");
        //在服务器端session中查找是否存在当前用户
        User user = controller.getSessionAttr(cuser);
        if (user == null || inv.getMethodName().equals("ulogin"))
            controller.redirect(controller.getRequest().getContextPath()+"/ulogin.jsp");
        else {
            inv.invoke();
        }
    }
}
