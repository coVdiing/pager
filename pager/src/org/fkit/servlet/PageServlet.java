package org.fkit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkit.domain.PageBean;
import org.fkit.service.UserService;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��ǰ�ǵڼ�ҳ
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		//ÿҳ��ʾ�ļ�¼��
		int pageSize = 5;
		//����service�㷽�������д���
		UserService us = new UserService();
		//��ȡһ��PageBean����pb�а��������з�ҳ��Ҫ������
		PageBean pb = us.findAllUserWithPage(pageNum, pageSize);
		//��pb����request����
		request.setAttribute("pageBean", pb);
		request.getRequestDispatcher("/page/main.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
