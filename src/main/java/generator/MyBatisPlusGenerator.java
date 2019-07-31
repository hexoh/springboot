package generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 
 * @author hexh
 *
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\workspace-swp\\SWP\\src\\main\\java");//这里写你自己的java目录
        gc.setFileOverride(true);//是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("ZGY");
        gc.setMapperName("%sDao");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.SQL_SERVER);

        dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dsc.setUsername("sa");
        dsc.setPassword("111111");
        dsc.setUrl("jdbc:sqlserver://192.168.1.168:1433;DatabaseName=SWP_DB");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{"t_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] {"t_site_info"});//生成表order 不加生成所有表
        strategy.setSuperEntityClass("com.sl.common.base.BaseEntity");
        strategy.setSuperControllerClass("com.sl.common.base.BaseController");
        strategy.setSuperMapperClass("com.sl.common.base.SuperMapper");
        strategy.setSuperEntityColumns(new String[] {"id","createTime","createBy","updateTime","updateBy","status"}) ;
        
        mpg.setStrategy(strategy);
       
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity("com.sl.site.entity");
        
        pc.setMapper("com.sl.site.mapper.dao");
        
        pc.setXml("com.sl.site.mapper");
        
        pc.setService("com.sl.site.service");       //本项目没用，生成之后删掉
        
        pc.setServiceImpl("com.sl.site.service.impl");   //本项目没用，生成之后删掉
        
        pc.setController("com.sl.site.controller");    //本项目没用，生成之后删掉
        
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();

    }

}