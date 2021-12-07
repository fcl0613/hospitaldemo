package com.hospital.servlet.doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entity.Doctor;
import com.hospital.service.doctor.impl.DoctorServiceImpl;

/**
 * Servlet implementation class DoRequest
 */
@WebServlet("/doctor/dorequest")
public class DoRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String weekStr = request.getParameter("week");
		String timeStr = request.getParameter("time");
		if (weekStr == null || timeStr == null || "".equals(weekStr) || "".equals(timeStr)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请先选择要调班的时间');");
			out.write("location.href='torequest';");
			out.write("</script>");
			out.close();
			return;
		}
		String reason = request.getParameter("reason");
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int res = doctorServiceImpl.requestDay(doctor.getId(), Integer.valueOf(weekStr), Integer.valueOf(timeStr), reason,simpleDateFormat.format(date));
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('申请提交成功');");
			out.write("location.href='selectsche';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('申请提交失败');");
			out.write("location.href='selectsche';");
			out.write("</script>");
		}
		out.close();
	}

}
