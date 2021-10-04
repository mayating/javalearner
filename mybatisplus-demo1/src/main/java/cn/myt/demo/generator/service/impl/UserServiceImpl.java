package cn.myt.demo.generator.service.impl;

import cn.myt.demo.generator.entity.User;
import cn.myt.demo.generator.mapper.UserMapper;
import cn.myt.demo.generator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mayating
 * @since 2021-10-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
