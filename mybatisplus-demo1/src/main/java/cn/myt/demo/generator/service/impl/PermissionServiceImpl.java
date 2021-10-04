package cn.myt.demo.generator.service.impl;

import cn.myt.demo.generator.entity.Permission;
import cn.myt.demo.generator.mapper.PermissionMapper;
import cn.myt.demo.generator.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
