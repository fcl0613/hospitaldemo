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
 * Servlet implementation class ToUpdateAnnouncemnet
 */
@WebServlet("/manage/toupdateannouncement")
public class ToUpdateAnnouncemnet extends HttpServlet {
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
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String releasedate = request.getParameter("releasedate");
		AnnouncementServiceImpl announcementServiceImpl = new AnnouncementServiceImpl();
		String desc = announcementServiceImpl.getDescById(Integer.valueOf(idStr));
		request.setAttribute("id", idStr);
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		request.setAttribute("releasedate", releasedate);
		request.setAttribute("desc", desc);
		request.getRequestDispatcher("updateannouncement.jsp").forward(request, response);
	}
}
