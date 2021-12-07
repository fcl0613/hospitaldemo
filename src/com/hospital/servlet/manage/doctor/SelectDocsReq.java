package com.hospital.servlet.manage.doctor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.ScheduleServiceImpl;
import com.hospital.view.RequestView;

/**
 * Servlet implementation class SelectDocsReq
 */
@WebServlet("/manage/selectdocsreq")
public class SelectDocsReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 10;
		int page = 1;
		String curPageStr = request.getParameter("cp");
		ScheduleServiceImpl scheduleServiceImpl = new ScheduleServiceImpl();
		if (curPageStr != null) {
			page = Integer.parseInt(curPageStr);
		}
		int arr[] = scheduleServiceImpl.pageAndTotal(count);
		List<RequestView> list = scheduleServiceImpl.selectaUser(page, count);
		request.setAttribute("list", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("cpage", page);
		request.setAttribute("totalpage", arr[1]);
		request.getRequestDispatcher("request.jsp").forward(request, response);
	}

}
