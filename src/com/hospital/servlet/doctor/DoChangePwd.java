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
 * Servlet implementation class DoChangePwd
 */
@WebServlet("/doctor/dochangepwd")
public class DoChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		int res = doctorServiceImpl.changePwd(doctor.getId(), password);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			session.removeAttribute("doctor");
			session.removeAttribute("isDoctorLogin");
			out.write("<script>");
			out.write("alert('密码修改成功,请重新登录');");
			out.write("location.href='/hospital/doctorlogin.jsp';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('密码修改失败');");
			out.write("location.href='index.jsp';");
			out.write("</script>");
		}
		out.close();
	}

}
