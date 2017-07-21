package cn.caoler.controller;

import cn.caoler.model.Admin;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;

/**
 * Author Caole
 * CreateDate: 2017/6/12
 * CreateTime: 14:34
 */
public class LoginController extends Controller{
    public void index(){
        render("ulogin.jsp");
    }

    public void loginAdmin(){
        String uname = getPara("admin.id");
        String sql = "SELECT * FROM t_admin where id=? ";

        Admin admin = Admin.dao.findFirst(sql,uname);
        if (admin != null) {
            String pwd = getPara("admin.password");
            //String password = admin.get("password");
            if (admin.get("password").equals(pwd)) {
                //生成唯一标识
                String sessionid = SessionIdKit.me().generate(getRequest());
                //设置服务器端session
                setSessionAttr(sessionid,admin);
                //设置用户端cookie
                setCookie("id",sessionid,100);
                render("/admin");
            } else {
                //密码不正确
                setAttr("PwdErrMsg","用户名或者密码不正确！");
                render("ulogin.jsp");
            }
        } else {
            //用户不存在
            setAttr("UnameErrMsg","用户名不存在！");
            render("ulogin.jsp");
        }
    }
}
