package cn.myt.demo3;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Oracle 数据库配置类
 *
 * @author mayating
 * @date 2021/10/11 11:37 上午
 */
@Configuration
@Profile("oracle")
public class OracleConfig implements DatabaseConfig {
    @Override
    public void connector() {
        System.out.println("项目使用 Oracle 数据库环境");
    }
}
