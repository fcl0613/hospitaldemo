package com.hospital.servlet.manage.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Doctor;
import com.hospital.entity.Work;
import com.hospital.service.manage.impl.WorkServiceImpl;

/**
 * Servlet implementation class DoAddRoaster
 */
@WebServlet("/manage/doaddschedule")
public class DoAddSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("did");
		if (idStr == null || "".equals(idStr)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请先选择医生');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
			out.close();
			return;
		}
		String weekStr = request.getParameter("week");
		String timeStr = request.getParameter("time");
		String numberStr = request.getParameter("number");
		Work work = new Work(null, new Doctor(Integer.valueOf(idStr), null),
				Integer.valueOf(weekStr),
				Integer.valueOf(timeStr),
				Integer.valueOf(numberStr),
				null);
		WorkServiceImpl workServiceImpl = new WorkServiceImpl();
		int res = workServiceImpl.addRoaster(work);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('排班添加成功');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('排班添加失败');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
		}
		out.close();
	}

}
