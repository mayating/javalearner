package cn.myt.service;

import cn.myt.pojo.ShiroUser;
import cn.myt.pojo.ShiroUserPermission;

import java.util.List;

/**
 * @author mayating
 * @date 2021/10/17 10:44 下午
 */
public interface IShiroUserService {

    void addUser(ShiroUser shiroUser);

    ShiroUser findUser(String username);

    List<ShiroUserPermission> queryShiroUserPermissionByUsername(String username);
}
