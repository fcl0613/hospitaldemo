package com.hospital.servlet.manage.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDepartment
 */
@WebServlet("/manage/toupdatedepartment")
public class ToUpdateDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depidStr = request.getParameter("depid");
		String depname = request.getParameter("depname");
		String deplocation = request.getParameter("deplocation");
		String depdesc = request.getParameter("depdesc");
		String deptyp = request.getParameter("deptype");
		
		request.setAttribute("depid", depidStr);
		request.setAttribute("depname", depname);
		request.setAttribute("deplocation", deplocation);
		request.setAttribute("depdesc", depdesc);
		request.setAttribute("deptype", deptyp);
		request.getRequestDispatcher("updatedepartment.jsp").forward(request, response);
	}

}
