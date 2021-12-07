package com.hospital.servlet.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
@WebServlet("/adminlogout")
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		session.removeAttribute("isAdminLogin");
		PrintWriter out = response.getWriter();
		out.write("<script>");
		out.write("alert('退出成功');");
		out.write("location.href='/hospital/adminlogin.jsp';");
		out.write("</script>");
		out.close();
	}

}
