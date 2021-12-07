package com.hospital.servlet.manage.work;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Work;
import com.hospital.service.manage.impl.WorkServiceImpl;
import com.hospital.view.WorkView;

/**
 * Servlet implementation class SelectRoaster
 */
@WebServlet("/manage/selectschedule")
public class SelectSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		int count = 10;
		String cpStr = request.getParameter("cp");
		String keyword = request.getParameter("keywords");
		WorkServiceImpl workServiceImpl = new WorkServiceImpl();
		if (cpStr != null) {
			page = Integer.parseInt(cpStr);
		}
		int[] arr = workServiceImpl.pageAndTotal(count, keyword);
		List<Work> list = workServiceImpl.selectaRoaster(keyword, page, count);
		List<WorkView> listview = new ArrayList<WorkView>();
		for (Work work : list) {
			listview.add(new WorkView(work));
		}
		request.setAttribute("list", listview);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("cpage", page);
		request.setAttribute("totalpage", arr[1]);
		if (keyword != null && !"".equals(keyword)) {
			request.setAttribute("searchelement", "&keywords="+keyword);
		}
		request.getRequestDispatcher("work.jsp").forward(request, response);
	}

}
