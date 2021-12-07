package com.hospital.servlet.manage.announcement;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.Admin;
import com.hospital.entity.Announcement;
import com.hospital.service.manage.impl.AnnouncementServiceImpl;

/**
 * Servlet implementation class AddAnnouncement
 */
@WebServlet("/manage/addannouncement")
public class AddAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		String author = admin.getAccount();	//后期用session代替
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String releasedate = simpleDateFormat.format(date);
		Announcement announcement = new Announcement(null, title, content, author, releasedate, null);
		AnnouncementServiceImpl announcementServiceImpl = new AnnouncementServiceImpl();
		int res = announcementServiceImpl.addAnnouncement(announcement);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('公告添加成功');");
			out.write("location.href='addannouncement.jsp';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('公告添加失败');");
			out.write("location.href='addannouncement.jsp';");
			out.write("</script>");
		}
		out.close();
	}

}
