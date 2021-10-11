package cn.myt.demo3;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Sybase 数据库配置类
 *
 * @author mayating
 * @date 2021/10/11 11:39 上午
 */
@Configuration
@Profile("sybase")
public class SybaseConfig implements DatabaseConfig {
    @Override
    public void connector() {
        System.out.println("项目使用 Sybase 数据库环境");
    }
}
