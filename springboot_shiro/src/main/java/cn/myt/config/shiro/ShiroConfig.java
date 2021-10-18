package cn.myt.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author mayating
 * @date 2021/10/15 9:19 上午
 */
@Configuration
public class ShiroConfig {

    @Bean
    public FirstRealm getRealm() {
        FirstRealm firstRealm = new FirstRealm();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(2048);
        firstRealm.setCredentialsMatcher(hashedCredentialsMatcher);

        // Md5CredentialsMatcher 和 HashedCredentialsMatcher都可以，只是前者已经不推荐使用了
        // 为 Realm 更换 密码匹配器，用来匹配 MD5+盐+hash 散列来加密的密码
        //Md5CredentialsMatcher md5CredentialsMatcher = new Md5CredentialsMatcher();
        // 告知散列的次数
        //md5CredentialsMatcher.setHashIterations(2048);

        // ehcache
        ////开启缓存
        ////firstRealm.setCachingEnabled(true); //开启全局的缓存管理
        //firstRealm.setAuthenticationCachingEnabled(true); //开启认证缓存
        ////firstRealm.setAuthorizationCachingEnabled(true); //开启授权缓存
        //firstRealm.setAuthenticationCacheName("authenticationCache"); // 设置缓存名称--认证
        //firstRealm.setAuthorizationCacheName("authorizationCache");//设置缓存名称--授权
        //firstRealm.setCacheManager(new EhCacheManager()); //告诉 自定义realm 使用哪种缓存实现
        firstRealm.setCacheManager(new MyRedisCacheManager());

        System.out.println(firstRealm);
        return firstRealm;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(FirstRealm firstRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(firstRealm);
        return defaultWebSecurityManager;
    }

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        HashMap<String, String> map = new HashMap<>();
        //anon 表示资源无需认证授权
        map.put("/user/register", "anon");
        map.put("/user/login", "anon");
        map.put("/user/logout", "anon");
        map.put("/jsp/register.jsp", "anon");
        map.put("/jsp/login.jsp", "anon");

        // authc 表示资源需要经过认证授权
        map.put("/**", "authc"); // 表示所有资源都要经过认证授权
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        //设置授权失败返回的页面
        shiroFilterFactoryBean.setLoginUrl("login.jsp"); // 这是默认值，指定受限资源未登录的展示页
        shiroFilterFactoryBean.setUnauthorizedUrl("error.jsp"); // 认证失败返回页面
        return shiroFilterFactoryBean;
    }
}
