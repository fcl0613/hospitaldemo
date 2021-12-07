package com.hospital.servlet.manage.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.User;
import com.hospital.service.manage.impl.UserServiceImpl;

/**
 * Servlet implementation class SelectUser
 */
@WebServlet("/manage/selectuser")
public class SelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int count = 10;
		String cpStr = request.getParameter("cp");
		String keyword = request.getParameter("keywords");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		if (cpStr != null) {
			page = Integer.parseInt(cpStr);
		}
		int[] arr = userServiceImpl.pageAndTotal(count, keyword);
		List<User> list = userServiceImpl.selectaUser(keyword, page, count);
		request.setAttribute("list", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("cpage", page);
		request.setAttribute("totalpage", arr[1]);
		if (keyword != null && !"".equals(keyword)) {
			request.setAttribute("searchelement", "&keywords="+keyword);
		}
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}
}
