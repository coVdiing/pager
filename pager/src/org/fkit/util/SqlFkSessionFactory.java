package org.fkit.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlFkSessionFactory {

	public static SqlSession getSqlSession(){
		InputStream in;
		SqlSessionFactory sf = null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			sf = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sf.openSession();
	}
	
}
