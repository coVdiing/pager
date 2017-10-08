<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页示例</title>
</head>
<body>
<!-- 构建分页导航 -->
<table border="1" align="center">
	<tr>
		<th>用户名</th><th>性别</th><th>描述</th>
	</tr>
	<c:forEach items="${requestScope.pageBean.list}" var="user">
		<tr>
			<td>${user.name}</td>
			<td>${user.sex}</td>
			<td>${user.description}</td>
		</tr>
	</c:forEach>
	
</table>
<div align="center">
 	共有<span style="color:red">${requestScope.pageBean.totalRecord}</span>个员工
	,共<span style="color:red">${requestScope.pageBean.totalPage}</span>页，当前为
	<span style="color:red">${requestScope.pageBean.pageNum}</span>页<br>

	<a href="${pageContext.request.contextPath}/PageServlet?pageNum=1">首页</a>

<!-- 如果当前页为第一页时，就没有上一页这个超链接显示 -->
<c:if test="${requestScope.pageBean.pageNum == 1}">
	<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i" >
		<c:if test="${requestScope.pageBean.pageNum == i}">
			${i} 
		</c:if>
		<c:if test="${requestScope.pageBean.pageNum != i}">
			<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${i}">${i}</a>
		</c:if>
	</c:forEach>
	<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>
</c:if>

<!-- 如果当前页不是第一页或者最后一页，则有上一页和下一页超链接提示 -->
<c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage }">
	<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
	<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
		<c:if test="${requestScope.pageBean.pageNum == i}">
			${i} 
		</c:if>
		<c:if test="${requestScope.pageBean.pageNum != i}">
			<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${i}">${i}</a>
		</c:if>
	</c:forEach>
	<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>
</c:if>

<!-- 如果当前页是最后一页，则只有上一页超链接，没有下一页的  -->
<c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage}">
	<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
	<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
		<c:if test="${requestScope.pageBean.pageNum == i}">
			${i} 
		</c:if>
		<c:if test="${requestScope.pageBean.pageNum != i}">
			<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${i}">${i}</a>
		</c:if>
	</c:forEach>	
</c:if>
<a href="${pageContext.request.contextPath}/PageServlet?pageNum=${requestScope.pageBean.totalPage}">尾页</a>
</div>

</body>
</html>