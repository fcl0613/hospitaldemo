package com.hospital.servlet.manage.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.DoctorServiceImpl;

/**
 * Servlet implementation class ChickAccount
 */
@WebServlet("/manage/chickaccount")
public class ChickAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		int res = doctorServiceImpl.chickAccount(account);
		PrintWriter p = response.getWriter();
		if (res > 0) {
			p.print("false");
		}else {
			p.print("true");
		}
		p.close();
	}
}
