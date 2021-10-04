package cn.myt.demo.pharse2.mapper;

import cn.myt.demo.pharse2.pojo.Role;
import cn.myt.demo.pharse2.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author mayating
 * @date 2021/10/4 12:19 下午
 */
public interface UserMapper extends BaseMapper<User> {

    // 根据用户名获取用户信息
    @Select("select * from user where name = #{username}")
    User findUserByName(String username);

    // 获取用户所拥有的角色
    @Select("select * from  role where rolecode in(select rolecode from userrole where username = #{userName})")
    Set<Role> getUserRoles(String username);
}
