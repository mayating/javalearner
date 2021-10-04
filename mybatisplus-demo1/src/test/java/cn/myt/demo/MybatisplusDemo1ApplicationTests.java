package cn.myt.demo;

import cn.myt.demo.pharse2.mapper.RoleMapper;
import cn.myt.demo.pharse2.mapper.UserMapper;
import cn.myt.demo.pharse2.pojo.Permission;
import cn.myt.demo.pharse2.pojo.Role;
import cn.myt.demo.pharse2.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Set;

//@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusDemo1ApplicationTests {

	//@Autowired
	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;

	@Test
	void contextLoads() {
		// CRUD

		//// 1.查询所有的数据
		//List<User> users = userMapper.selectList(null);
		//System.out.println(users);
		//
		//// 2.根据 ID 删除
		//userMapper.deleteById(1);
		//
		////// 3.添加数据
		//User user = new User();
		//user.setName("老王");
		//user.setEmail("laowang@qq.com");
		//user.setAge(18);
		//userMapper.insert(user);
		//
		//System.out.println(user);
		//
		//// 4.更新数据
		//user.setName("老王王");
		//user.setEmail("lanwangwang@qq.com");
		//userMapper.updateById(user);
	}

	@Test
	public void testPharse2() {

		// 1.
		User user = userMapper.findUserByName("cuihua");
		System.out.println(user);
		// 2.
		Set<Role> userRoles = userMapper.getUserRoles("cuihua");
		System.out.println(userRoles);
		// 3.
		Set<Permission> rolePermissions = roleMapper.getRolePermissions("001");
		System.out.println(rolePermissions);
	}
}
