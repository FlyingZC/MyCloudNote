package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.dao.UserDao;
import com.zc.entity.User;

public class T02Dao {
	ApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	@Test
	public void testSaveUser(){
		UserDao dao=(UserDao)ctx.getBean("userDao");
		User user=new User("123", "ZCCX","123", "", "Cat");
		dao.saveUser(user);
	}
	@Test
	public void testFindUserById(){
	    UserDao dao = ctx.getBean("userDao", UserDao.class);
	    String id="123";
	    User user=dao.findUserById(id);
	    System.out.println(user); 
	}
}
