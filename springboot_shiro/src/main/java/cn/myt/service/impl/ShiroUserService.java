package cn.myt.service.impl;

import cn.myt.mapper.ShiroUserMapper;
import cn.myt.pojo.ShiroUser;
import cn.myt.pojo.ShiroUserPermission;
import cn.myt.service.IShiroUserService;
import cn.myt.util.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mayating
 * @date 2021/10/17 10:46 下午
 */
@Service
@Transactional
public class ShiroUserService implements IShiroUserService {

    @Resource
    private ShiroUserMapper shiroUserMapper;

    @Override
    public void addUser(ShiroUser shiroUser) {
        // 使用 MD5+盐+hash 散列对密码加密
        String salt = SaltUtil.getSalt(10);
        Md5Hash md5Hash = new Md5Hash(shiroUser.getPassword(), salt, 2048);
        shiroUser.setPassword(md5Hash.toString());
        shiroUser.setSalt(salt);
        shiroUserMapper.insertUser(shiroUser);
    }

    @Override
    public ShiroUser findUser(String username) {
        ShiroUser shiroUser = shiroUserMapper.selectUser(username);
        return shiroUser;
    }

    @Override
    public List<ShiroUserPermission> queryShiroUserPermissionByUsername(String username) {
        List<ShiroUserPermission> shiroUserPermissions = shiroUserMapper.queryShiroUserPermissionByUsername(username);
        return shiroUserPermissions;
    }
}
