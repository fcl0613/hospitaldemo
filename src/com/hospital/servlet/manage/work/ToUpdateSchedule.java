package com.hospital.servlet.manage.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Work;
import com.hospital.service.manage.impl.WorkServiceImpl;

/**
 * Servlet implementation class ToUpdateToaster
 */
@WebServlet("/manage/toupdateschedule")
public class ToUpdateSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String did = request.getParameter("id");
		if (did == null || "".equals(did)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请先选择医生');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
			out.close();
			return;
		}
		WorkServiceImpl workServiceImpl = new WorkServiceImpl();
		Work work = workServiceImpl.selectRoasterByDoctorid(Integer.valueOf(did));
		request.setAttribute("work", work);
		request.getRequestDispatcher("updateroaster.jsp").forward(request, response);
	}

}
