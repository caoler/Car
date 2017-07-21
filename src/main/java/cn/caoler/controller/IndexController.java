package cn.caoler.controller;

import cn.caoler.model.User;
import cn.caoler.utils.DateUtils;
import cn.caoler.utils.MD5;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;

/**
 * Author Caole
 * CreateDate: 2017/6/14
 * CreateTime: 12:59
 */
public class IndexController extends Controller{
    public void index(){
        render("ulogin.jsp");
    }

    public void regist() {
        String mima = getPara("user.password");
        String confirm = getPara("reg.confirmpwd");

        System.out.println(mima);

        if (mima.length()<6 || mima.length()>20) {
            setAttr("pwdMsg","密码长度为6——20位");
            render("regist.jsp");
        } else if (!confirm.equals(mima)) {
            setAttr("confirmMsg","输入的密码不一致！");
            render("regist.jsp");
        } else {
            String uname = getPara("user.id");
            String sql = "SELECT * FROM t_user WHERE id=? ";
            User user = getModel(User.class);
            // 如果用户名已经被注册，提示错误信息
            if (user.findFirst(sql, uname) != null) {
                setAttr("UnameMsg", "该用户已被注册!");
                render("regist.jsp");
            } else {
                // 使用工具包把当前时间转换成unix时间戳再转换成string类型
                // 注册时间，并作为用户密码md5加密的salt
                String reg_date = DateUtils.getNowTime();

                // 使用jfinal标识生成工具生成随机数作为密码的盐
                String password = MD5.GetMD5Code(getPara("user.password") + reg_date);

                user.setRegDate(reg_date);
                user.setPassword(password);
                user.save();

                setAttr("SuccessMsg", "注册成功！");
                render("regist.jsp");
            }
        }
    }


    public void ulogin() {
        String uname = getPara("user.id");
        String sql = "SELECT * FROM t_user WHERE id=? LIMIT 1";
        User user = User.dao.findFirst(sql, uname);
        if (user != null){
            String pwd = MD5.GetMD5Code(getPara("user.password") + user.getRegDate());

            if (user.getPassword().equals(pwd)) {
                // 生成唯一标识
                String sessionId = SessionIdKit.me().generate(getRequest());
                // 设置服务器端session
                setSessionAttr(sessionId, user);
                // 设置用户端cookie
                setCookie("id", sessionId, 60000);
                redirect("/front");
            } else {
                // 密码不正确
                setAttr("PwdErrMsg", "用户名或密码不正确！");
                render("ulogin.jsp");
            }
        } else {
            // 用户不存在
            setAttr("UnameErrMsg", "用户不存在！");
            render("ulogin.jsp");
        }
    }
}
