package com.hospital.servlet.doctor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.Doctor;
import com.hospital.service.doctor.impl.DoctorServiceImpl;
import com.hospital.view.RequestView;

/**
 * Servlet implementation class SelectRequest
 */
@WebServlet("/doctor/selectrequest")
public class SelectRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		List<RequestView> list = doctorServiceImpl.selectRequest(doctor.getId());
		request.setAttribute("list", list);
		request.getRequestDispatcher("request.jsp").forward(request, response);
	}
}
