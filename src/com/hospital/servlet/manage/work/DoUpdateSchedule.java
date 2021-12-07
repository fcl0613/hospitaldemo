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
 * Servlet implementation class DoUpdateRoaster
 */
@WebServlet("/manage/doupdateschedule")
public class DoUpdateSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String didStr = request.getParameter("did");
		String weekStr = request.getParameter("week");
		String timeStr = request.getParameter("time");
		String numberStr = request.getParameter("number");
		String stateStr = request.getParameter("state");
		Work work = new Work(null, new Doctor(Integer.valueOf(didStr), null), 
				Integer.valueOf(weekStr), Integer.valueOf(timeStr), Integer.valueOf(numberStr), Integer.valueOf(stateStr));
		WorkServiceImpl workServiceImpl = new WorkServiceImpl();
		int res = workServiceImpl.updateRoaster(work);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('排班信息更新成功');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('排班信息更新失败');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
		}
		out.close();
	}

}
