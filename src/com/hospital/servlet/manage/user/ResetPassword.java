package com.hospital.servlet.manage.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.UserServiceImpl;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/manage/resetpassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		PrintWriter out = response.getWriter();
		if (idStr == null || "".equals(idStr)) {
			out.write("<script>");
			out.write("alert('密码重置失败');");
			out.write("location.href='selectuser';");
			out.write("</script>");
			out.close();
			return;
		}
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		int res = userServiceImpl.resetPassword(Integer.valueOf(idStr));
		if (res > 0) {
			out.write("<script>");
			out.write("alert('密码重置成功');");
			out.write("location.href='selectuser';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('密码重置失败');");
			out.write("location.href='selectuser';");
			out.write("</script>");
		}
		out.close();
	}

}
