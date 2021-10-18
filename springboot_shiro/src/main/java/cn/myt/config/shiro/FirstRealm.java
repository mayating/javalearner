package cn.myt.config.shiro;

import cn.myt.pojo.ShiroUser;
import cn.myt.pojo.ShiroUserPermission;
import cn.myt.service.IShiroUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mayating
 * @date 2021/10/15 9:08 上午
 */
public class FirstRealm extends AuthorizingRealm {

    @Resource
    private IShiroUserService shiroUserService;

    //权限信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("触发授权操作了");
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //根据用户名获取该用户的所有权限
        List<ShiroUserPermission> shiroUserPermissionList = shiroUserService.queryShiroUserPermissionByUsername(username);
        //给simpleAuthorizationInfo添加角色、权限
        shiroUserPermissionList.stream().forEach(
                shiroUserPermission -> {
                    if (shiroUserPermission.getRole() != null) {
                        simpleAuthorizationInfo.addRole(shiroUserPermission.getRole());
                    }
                    if (shiroUserPermission.getPermission() != null) {
                        simpleAuthorizationInfo.addStringPermission(shiroUserPermission.getPermission());
                    }
                }
        );
        return simpleAuthorizationInfo;
    }

    //认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        ShiroUser shiroUser = shiroUserService.findUser(usernamePasswordToken.getUsername());
        if (shiroUser != null) {
            return new SimpleAuthenticationInfo(shiroUser.getUsername(), shiroUser.getPassword(),
                    ByteSource.Util.bytes(shiroUser.getSalt()), this.getName());
        }
        return null;
    }
}
