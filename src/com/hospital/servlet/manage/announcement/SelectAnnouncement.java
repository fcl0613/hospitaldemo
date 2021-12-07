package com.hospital.servlet.manage.announcement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Announcement;
import com.hospital.service.manage.impl.AnnouncementServiceImpl;

/**
 * Servlet implementation class SelectAnnouncement
 */
@WebServlet("/manage/selectannouncement")
public class SelectAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int count = 10;
		String cpStr = request.getParameter("cp");
		String keyword = request.getParameter("keywords");
		AnnouncementServiceImpl announcementServiceImpl = new AnnouncementServiceImpl();
		if (cpStr != null) {
			page = Integer.parseInt(cpStr);
		}
		int[] arr = announcementServiceImpl.pageAndTotal(count, keyword);
		List<Announcement> list = announcementServiceImpl.selectaAnnouncement(keyword, page, count);
		request.setAttribute("list", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("cpage", page);
		request.setAttribute("totalpage", arr[1]);
		if (keyword != null && !"".equals(keyword)) {
			request.setAttribute("searchelement", "&keywords="+keyword);
		}
		request.getRequestDispatcher("announcement.jsp").forward(request, response);
	}
}
