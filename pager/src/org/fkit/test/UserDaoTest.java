package org.fkit.test;

import java.util.List;

import org.fkit.dao.UserDao;
import org.fkit.domain.User;
import org.fkit.util.SqlFkSessionFactory;
import org.junit.Test;

public class UserDaoTest {
	UserDao ud = SqlFkSessionFactory.getSqlSession().getMapper(UserDao.class);
	@Test
	public void fun(){
		List<User> users = ud.findAllUser();
		for(User user:users){
			System.out.println(user);
		}
	}
	
	@Test
	public void fun2(){
		List<User> users = ud.findAll(0, 2);
		for(User user:users){
			System.out.println(user);
		}
	}
}
