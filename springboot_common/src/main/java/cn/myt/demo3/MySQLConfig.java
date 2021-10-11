package cn.myt.demo3;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * MySQL 数据库配置类
 *
 * @author mayating
 * @date 2021/10/11 11:35 上午
 */
@Configuration //指定为配置类
@Profile("mysql") //配置环境名称
public class MySQLConfig implements DatabaseConfig {
    @Override
    public void connector() {
        System.out.println("项目使用 MySQL 数据库环境");
    }
}
