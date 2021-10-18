

## Spring Boot + Shiro + JSP

1.pom.xml   
```xml
<dependency>
   <groupId>org.apache.shiro</groupId>
   <artifactId>shiro-spring-boot-web-starter</artifactId>
   <version>1.8.0</version>
</dependency>
```

2.自定义 Realm   
FirstRealm，继承 AuthorizingRealm，重写doGetAuthorizationInfo、doGetAuthenticationInfo权限信息、认证信息2个方法   
注：Shiro 的数据来源都是 Realm

3.Shiro配置类  
> Realm -> SecurityManager -> ShiroFilter   

将自定义 Realm 注入到 Spring 容器，重写 DefaultWebSecurityManager，重写 ShiroFilterFactoryBean
注：ShiroFilter 是通过 ShiroFilterFactoryBean 来获取的；DefaultWebSecurityManager，是适用于 web 版本的安全管理器；
    密码加密与解析（ MD5+盐+hash 散列）
    

## Shiro

缓存：认证和权限
过滤器：Shiro 提供了多个默认的过滤器，可用这些默认起来配置控制指定 url 的权限，常用的有：   
    anon--指定 url 可以匿名访问；
    authc--指定 url 需要 form 表单登录，默认会从请求中获取username、password、rememberMe 等参数并尝试登录，如果登录不了就会跳转到loginUrl 配置的路径。
    也可用这个过滤器做默认的登录逻辑。