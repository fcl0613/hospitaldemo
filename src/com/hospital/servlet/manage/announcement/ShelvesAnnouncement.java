package com.hospital.servlet.manage.announcement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.AnnouncementServiceImpl;

/**
 * Servlet implementation class ShelvesAnnouncement
 */
@WebServlet("/manage/shelvesannouncement")
public class ShelvesAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('你未选择标题');");
			out.write("location.href='selectannouncement';");
			out.write("</script>");
			out.close();
			return;
		}
		AnnouncementServiceImpl announcementServiceImpl = new AnnouncementServiceImpl();
		int res = announcementServiceImpl.shelvesAnnouncement(Integer.valueOf(idStr));
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('公告下架成功');");
			out.write("location.href='selectannouncement';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('公告下架失败');");
			out.write("location.href='selectannouncement';");
			out.write("</script>");
		}
		out.close();
	}
}
