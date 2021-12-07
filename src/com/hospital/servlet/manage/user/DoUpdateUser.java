package com.hospital.servlet.manage.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.User;
import com.hospital.service.manage.impl.UserServiceImpl;

/**
 * Servlet implementation class DoUpdateUser
 */
@WebServlet("/doupdateuser")
public class DoUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("uid");
		String account = request.getParameter("account");
		String tel = request.getParameter("tel");
		String name = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		User user = new User(Integer.valueOf(idStr),account,null,tel,name,idcard,null);
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		int res = userServiceImpl.updateUser(user);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('信息更新成功');");
			out.write("location.href='manage/selectuser';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('信息更新失败');");
			out.write("location.href='manage/toupdateuser';");
			out.write("</script>");
		}
		out.close();
	}

}
