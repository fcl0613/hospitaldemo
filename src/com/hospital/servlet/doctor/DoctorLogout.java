package com.hospital.servlet.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoctorLogout
 */
@WebServlet("/doctor/doctorlogout")
public class DoctorLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("doctor");
		session.removeAttribute("isDoctorLogin");
		PrintWriter out = response.getWriter();
		out.write("<script>");
		out.write("alert('退出成功');");
		out.write("location.href='/hospital/doctorlogin.jsp';");
		out.write("</script>");
		out.close();
	}

}
