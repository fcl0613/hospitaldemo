package com.hospital.servlet.manage.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.User;

/**
 * Servlet implementation class ToUpdateUser
 */
@WebServlet("/manage/toupdateuser")
public class ToUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String account = request.getParameter("account");
		String tel = request.getParameter("tel");
		String name = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		
		User user = new User(Integer.valueOf(idStr), account, null, tel, name, idcard, null);
		request.setAttribute("user", user);
		request.getRequestDispatcher("updateuser.jsp").forward(request, response);
	}

}
