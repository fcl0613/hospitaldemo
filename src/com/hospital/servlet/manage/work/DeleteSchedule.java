package com.hospital.servlet.manage.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.WorkServiceImpl;

/**
 * Servlet implementation class DeleteRoaster
 */
@WebServlet("/manage/deleteschedule")
public class DeleteSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请先选择需要删除的排班');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
			out.close();
			return;
		}
		WorkServiceImpl workServiceImpl = new WorkServiceImpl();
		int res = workServiceImpl.deleteRoaster(Integer.valueOf(idStr));
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('排班删除成功');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('排班删除失败');");
			out.write("location.href='selectschedule';");
			out.write("</script>");
		}
		out.close();
	}
}
