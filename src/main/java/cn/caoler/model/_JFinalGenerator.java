package cn.caoler.model;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;


/**
 * Author Caole
 * CreateDate: 2017/6/15
 * CreateTime: 14:38
 */
public class _JFinalGenerator {
    public static DataSource getDataSource() {
        Prop prop = PropKit.use("config.properties");
        DruidPlugin druidPlugin = new DruidPlugin(prop.get("jdbcUrl"),prop.get("user"),prop.get("password"));
        druidPlugin.start();
        return druidPlugin.getDataSource();
    }
    public static void main(String[] args) {
        // base model 所使用的包名
        String baseModelPackageName = "cn.caoler.model.base";
        // base model 文件保存路径
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/cn/caoler/model/base";

        // model 所使用的包名 (_MappingKit 默认使用的包名)
        String modelPackageName = "cn.caoler.model";
        // model 文件保存路径 (_MappingKit 与 DataDictionary 文件默认保存路径)
        String modelOutputDir = baseModelOutputDir + "/..";

        // 创建生成器
        Generator gernerator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
        // 设置数据库方言
        gernerator.setDialect(new MysqlDialect());
        // 添加不需要生成的表名
        //gernerator.addExcludedTable("adv");
        // 设置是否在 Model 中生成 dao 对象
        gernerator.setGenerateDaoInModel(true);
        // 设置是否生成字典文件
        gernerator.setGenerateDataDictionary(false);
        // 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
        gernerator.setRemovedTableNamePrefixes("t_");
        // 生成
        gernerator.generate();
    }
}
