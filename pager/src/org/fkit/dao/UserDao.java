package org.fkit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.User;

public interface UserDao {
	@Select("select * from user_table")
	List<User> findAllUser();
	
	@Select("select * from user_table limit #{startIndex},#{pageSize}")
	List<User> findAll(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
}
