package cn.myt.demo.generator.service.impl;

import cn.myt.demo.generator.entity.Order;
import cn.myt.demo.generator.mapper.OrderMapper;
import cn.myt.demo.generator.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
