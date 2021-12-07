package com.hospital.servlet.manage.doctor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Doctor;
import com.hospital.service.manage.impl.DoctorServiceImpl;


/**
 * Servlet implementation class SelectDoctor
 */
@WebServlet("/manage/selectdoctor")
public class SelectDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 10;
		int page = 1;
		String keyword = request.getParameter("keywords");
		String curPageStr = request.getParameter("cp");
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		if (curPageStr != null) {
			page = Integer.parseInt(curPageStr);
		}
		int[] arr = doctorServiceImpl.pageAndTotal(count, keyword);
		List<Doctor> list = doctorServiceImpl.selectaDoctor(keyword, page, count);
		request.setAttribute("list", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("cpage", page);
		request.setAttribute("totalpage", arr[1]);
		if (keyword != null && !"".equals(keyword)) {
			request.setAttribute("searchelement", "&keywords="+keyword);
		}
		request.getRequestDispatcher("doctor.jsp").forward(request, response);
	}
}
