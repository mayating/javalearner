package cn.myt.demo;

import cn.myt.demo.page.mapper.UserMapper;
import cn.myt.demo.pharse2.mapper.RoleMapper;
import cn.myt.demo.pharse2.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

		//// 1.
		//User user = userMapper.findUserByName("cuihua");
		//System.out.println(user);
		//// 2.
		//Set<Role> userRoles = userMapper.getUserRoles("cuihua");
		//System.out.println(userRoles);
		//// 3.
		//Set<Permission> rolePermissions = roleMapper.getRolePermissions("001");
		//System.out.println(rolePermissions);
	}

	@Test
	public void testMapperCRUD() {
		// 1.  添加数据（一定要保证表的主键是自增状态）
        /*User user = new User();
        user.setName("老王");
        user.setEmail("laowang@kkb.com");
        user.setAge(18);
        userMapper.insert(user);*/

		// 2. 根据 id 删除
		// userMapper.deleteById(6);

		// 3. 根据 columnMap 条件，删除记录
		// Maps 属于 com.google.common.collect.Maps 包，来自于 Guava
		// Guava 中文是石榴的意思，该项目是 Google 的一个开源项目，包含许多 Google 核心的 Java 常用库
        /*Map<String, Object> columnMap = Maps.newHashMap();
        columnMap.put("id", 3);

        userMapper.deleteByMap(columnMap);*/

		// 4. 查询所有数据
		// 不指定条件，直接传递 null
        /*List<User> userList = userMapper.selectList(null);
        userList.forEach(user -> System.out.println("用户：" + user));*/

		// 5. 批量查询
		List<String> idList = new ArrayList<String>();
		idList.add("1");
		idList.add("2");
		List<User> userList = userMapper.selectBatchIds(idList);
		userList.forEach(user -> System.out.println("用户：" + user));

	}

	@Test
	public void testPage() {
		Page<User> userPage = new Page<>(1, 10);
		IPage<User> userIPage = userMapper.selectPageVo(userPage, "cuihua");
		System.out.println(userIPage.getTotal());
		System.out.println(userIPage.getRecords());
	}

}
