package com.hospital.servlet.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.Doctor;
import com.hospital.entity.Work;
import com.hospital.service.doctor.impl.DoctorServiceImpl;
import com.hospital.view.WorkView;

/**
 * Servlet implementation class ToRequest
 */
@WebServlet("/doctor/torequest")
public class ToRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		Work work = doctorServiceImpl.selectSchedule(doctor.getId());
		if (work == null) {
			request.getRequestDispatcher("subrequest.jsp").forward(request, response);
			return;
		}
		WorkView workView = new WorkView(work.getWeek(),work.getTime());
		request.setAttribute("workview", workView);
		request.getRequestDispatcher("subrequest.jsp").forward(request, response);
	}

}
