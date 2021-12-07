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

/**
 * Servlet implementation class DoctorLogin
 */
@WebServlet("/doctorlogin")
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		Doctor doctor = doctorServiceImpl.login(username, password);
		if (doctor != null) {
			HttpSession session = request.getSession();
			session.setAttribute("doctor", doctor);
			session.setAttribute("isDoctorLogin", "1");
			response.sendRedirect("/hospital/doctor/index.jsp");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('账号密码错误');");
			out.write("location.href='doctorlogin.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
