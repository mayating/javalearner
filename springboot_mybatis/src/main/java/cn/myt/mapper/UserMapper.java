package cn.myt.mapper;

import cn.myt.pojo.User;

import java.util.List;

/**
 * @author mayating
 * @date 2021/10/10 9:51 下午
 */
public interface UserMapper {

    List<User> selectUserList();

}
