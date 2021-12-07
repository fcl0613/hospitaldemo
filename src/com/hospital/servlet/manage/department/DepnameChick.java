package com.hospital.servlet.manage.department;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class Depname
 */
@WebServlet("/depnamechick")
public class DepnameChick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depName = request.getParameter("depname");
		if (depName != null && !"".equals(depName)) {
			DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
			int res = departmentServiceImpl.selectDepByDepname(depName);
			PrintWriter p = response.getWriter();
			if (res > 0) {
				p.print("false");
			}else {
				p.print("true");
			}
			p.close();
		}
	}
}
