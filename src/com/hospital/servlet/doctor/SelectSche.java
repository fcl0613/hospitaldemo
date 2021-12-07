package com.hospital.servlet.doctor;

import java.io.IOException;
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
import com.hospital.entity.Work;
import com.hospital.service.doctor.impl.DoctorServiceImpl;

/**
 * Servlet implementation class SelectSche
 */
@WebServlet("/doctor/selectsche")
public class SelectSche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		//后期用session代替
//		Integer did = 8;
//		did = Integer.valueOf(request.getParameter("did"));
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		Work work = doctorServiceImpl.selectSchedule(doctor.getId());
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("today", simpleDateFormat.format(date));
		if(work == null) {
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
			return;
		}
		int a = calendar.get(Calendar.DAY_OF_WEEK);
		a = (a+6)%7;
		if(a == 0) {
			a=7;
		}
		String[] week = new String[4];
		if (work.getWeek() != 8) {
			calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)-a+work.getWeek());
			date = calendar.getTime();
			week[0] = simpleDateFormat.format(date);
			week[1] = simpleDateFormat.format(date);
			calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)+7);
			date = calendar.getTime();
			week[2] = simpleDateFormat.format(date);
			week[3] = simpleDateFormat.format(date);
		}else {
			calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)-a+1);
			date = calendar.getTime();
			week[0] = simpleDateFormat.format(date);
			calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)+5);
			date = calendar.getTime();
			week[1] = simpleDateFormat.format(date);
			calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)+2);
			date = calendar.getTime();
			week[2] = simpleDateFormat.format(date);
			calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)+5);
			date = calendar.getTime();
			week[3] = simpleDateFormat.format(date);
		}
		String time = "未排班";
		switch(work.getTime()) {
			case 1:
				time = "上午";
				break;
			case 2:
				time = "下午";
				break;
			case 3:
				time = "全天";
				break;
		}
//		for (int i = 0; i < week.length; i++) {
//			System.out.println(week[i]);
//		}
//		System.out.println(time);
		request.setAttribute("week", week);
		request.setAttribute("time", time);
		request.getRequestDispatcher("schedule.jsp").forward(request, response);
	}

}
