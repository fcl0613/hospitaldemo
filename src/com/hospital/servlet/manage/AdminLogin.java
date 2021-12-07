package com.hospital.servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.Admin;
import com.hospital.service.impl.LoginServiceImpl;


/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		Admin a = new Admin(username, password);
		Admin admin = loginServiceImpl.adminLogin(a);
		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			session.setAttribute("isAdminLogin", "1");
			response.sendRedirect("/hospital/manage/index.jsp");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('用户登录失败');");
			out.write("location.href='adminlogin.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
