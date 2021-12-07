package com.hospital.servlet.manage.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToAddRoaster
 */
@WebServlet("/manage/toaddschedule")
public class ToAddSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请先选择医生');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
			out.close();
			return;
		}
		String dname = request.getParameter("dname");
		request.setAttribute("id", idStr);
		request.setAttribute("dname", dname);
		request.getRequestDispatcher("addroaster.jsp").forward(request, response);
	}

}
