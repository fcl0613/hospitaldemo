package com.hospital.servlet.manage.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.ScheduleServiceImpl;

/**
 * Servlet implementation class DisagreeReq
 */
@WebServlet("/manage/disagreereq")
public class DisagreeReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		PrintWriter out = response.getWriter();
		if (idStr == null || "".equals(idStr)) {
			out.write("<script>");
			out.write("alert('请先选择要操作的请求');");
			out.write("location.href='selectdocsreq';");
			out.write("</script>");
			out.close();
			return;
		}
		ScheduleServiceImpl scheduleServiceImpl = new ScheduleServiceImpl();
		int res = scheduleServiceImpl.disagreeReq(Integer.valueOf(idStr));
		if (res > 0) {
			out.write("<script>");
			out.write("alert('信息更新成功');");
			out.write("location.href='selectdocsreq';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('信息更新失败');");
			out.write("location.href='selectdocsreq';");
			out.write("</script>");
		}
		out.close();
	}

}
