package cn.myt.demo.page.mapper;

import cn.myt.demo.pharse2.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;

/**
 * @author mayating
 * @date 2021/10/4 2:25 下午
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username = #{username}")
    IPage<User> selectPageVo(Page<?> page, String username);
}
