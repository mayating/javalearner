package cn.myt.mapper;

import cn.myt.pojo.ShiroUser;
import cn.myt.pojo.ShiroUserPermission;

import java.util.List;

/**
 * @author mayating
 * @date 2021/10/17 10:47 下午
 */
public interface ShiroUserMapper {

    void insertUser(ShiroUser shiroUser);

    ShiroUser selectUser(String username);

    List<ShiroUserPermission> queryShiroUserPermissionByUsername(String username);
}
