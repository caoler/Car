package cn.caoler.common;

import cn.caoler.controller.AdminController;
import cn.caoler.controller.CarController;
import cn.caoler.controller.IndexController;
import cn.caoler.controller.LoginController;
import cn.caoler.model.*;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

/**
 * Author Caole
 * CreateDate: 2017/5/31
 * CreateTime: 20:00
 */
public class MainConfig extends JFinalConfig{

    public void configConstant(Constants me) {
        //配置常量
        //加载配置文件
        loadPropertyFile("config.properties");
        me.setDevMode(getPropertyToBoolean("devMode",false));
        me.setViewType(ViewType.JSP);
    }

    public void configRoute(Routes me) {
        me.add("/front", CarController.class);
        me.add("/admin", AdminController.class);
        me.add("/login", LoginController.class);
        me.add("/", IndexController.class);
    }

    public void configEngine(Engine me) {

    }

    public void configPlugin(Plugins me) {
        // 配置Drui数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(getProperty("jdbcUrl"),getProperty("user"),getProperty("password"));
        me.add(druidPlugin);
        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // 所有映射在 _MappingKit 中自动化搞定
        me.add(arp);
        _MappingKit.mapping(arp);
    }

    public void configInterceptor(Interceptors me) {

    }

    public void configHandler(Handlers me) {

    }
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8080, "/");
    }
}
