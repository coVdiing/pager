package org.fkit.service;

import java.util.List;

import org.fkit.dao.UserDao;
import org.fkit.domain.PageBean;
import org.fkit.domain.User;
import org.fkit.util.SqlFkSessionFactory;

public class UserService {
	UserDao ud = SqlFkSessionFactory.getSqlSession().getMapper(UserDao.class);
	public PageBean<User> findAllUserWithPage(int pageNum,int pageSize) {
		//������Ҫ��PageBean�е����ݴ����ã�Ȼ�󽫶��󴫻�ȥ
		//��Ҫ�����ݿ��л�ȡ�����û����������ж��٣����totalRecord��
		List<User> allUser = ud.findAllUser();
		int totalRecord = allUser.size();
		
		//����������ʼ���ݣ����ܴ���pageBean������
		PageBean pb = new PageBean(pageNum,pageSize,totalRecord);
		
		//��ȡPageBean�����е�startIndex
		int startIndex = pb.getStartIndex();
		
		//����startIndex��pageSize,�Ϳ����õ�ÿҳ��������
		pb.setList(ud.findAll(startIndex,pageSize));
		
		return pb;
	}
}