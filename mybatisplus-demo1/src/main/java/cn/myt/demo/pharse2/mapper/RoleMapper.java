package cn.myt.demo.pharse2.mapper;

import cn.myt.demo.pharse2.pojo.Permission;
import cn.myt.demo.pharse2.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author mayating
 * @date 2021/10/4 12:23 下午
 */
public interface RoleMapper extends BaseMapper<Role> {

    // 获取角色所拥有权限
    @Select("select * from permission where permissioncode in (select permissioncode from rolepermission where rolecode = #{roleCode})")
    Set<Permission> getRolePermissions(String roleCode);
}
