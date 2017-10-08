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
		//获取当前是第几页
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		//每页显示的记录数
		int pageSize = 5;
		//调用service层方法，进行处理
		UserService us = new UserService();
		//获取一个PageBean对象，pb中包含了所有分页需要的数据
		PageBean pb = us.findAllUserWithPage(pageNum, pageSize);
		//将pb放入request域中
		request.setAttribute("pageBean", pb);
		request.getRequestDispatcher("/page/main.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
