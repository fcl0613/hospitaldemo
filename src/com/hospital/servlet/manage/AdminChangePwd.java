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
 * Servlet implementation class AdminChangePwd
 */
@WebServlet("/manage/adminchangepwd")
public class AdminChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		admin.setPassword(password);
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		int res = loginServiceImpl.AdminchangePwd(admin);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			session.removeAttribute("admin");
			session.removeAttribute("isAdminLogin");
			out.write("<script>");
			out.write("alert('密码修改成功,请重新登录');");
			out.write("location.href='/hospital/adminlogin.jsp';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('密码修改失败');");
			out.write("location.href='index.jsp';");
			out.write("</script>");
		}
		out.close();
	}

}
