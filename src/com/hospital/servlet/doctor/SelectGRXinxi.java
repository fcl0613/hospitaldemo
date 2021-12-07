package com.hospital.servlet.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.Doctor;
import com.hospital.service.doctor.impl.DoctorServiceImpl;
import com.hospital.view.DoctorView;


/**
 * Servlet implementation class SelectGRXinxi
 */
@WebServlet("/doctor/selectgrxinxi")
public class SelectGRXinxi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		if (doctor == null) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请先选择要调班的时间');");
			out.write("location.href='selectsche';");
			out.write("</script>");
			out.close();
		}
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		DoctorView doctorv = doctorServiceImpl.selectgrxx(doctor.getId());
		request.setAttribute("doctorv", doctorv);
		request.getRequestDispatcher("grxinxi.jsp").forward(request, response);
	}

}
