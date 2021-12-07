package com.hospital.servlet.manage.announcement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Announcement;
import com.hospital.service.manage.impl.AnnouncementServiceImpl;

/**
 * Servlet implementation class DoUpdateAnnouncement
 */
@WebServlet("/manage/doupdateannouncement")
public class DoUpdateAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('更新失败');");
			out.write("location.href='selectannouncement';");
			out.write("</script>");
			out.close();
			return;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Announcement announcement = new Announcement(Integer.valueOf(idStr), title, content, null, null, null);
		AnnouncementServiceImpl announcementServiceImpl = new AnnouncementServiceImpl();
		int res = announcementServiceImpl.updateAnnouncement(announcement);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('信息更新成功');");
			out.write("location.href='selectannouncement';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('信息更新失败');");
			out.write("location.href='selectannouncement';");
			out.write("</script>");
		}
		out.close();
	}

}
