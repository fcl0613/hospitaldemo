package com.hospital.servlet.manage.doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Department;
import com.hospital.entity.Doctor;
import com.hospital.service.manage.impl.DepartmentServiceImpl;
import com.hospital.service.manage.impl.DoctorServiceImpl;

/**
 * Servlet implementation class ToUpdateDoctor
 */
@WebServlet("/manage/toupdatedoctor")
public class ToUpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("did");
		if (idStr == null || "".equals(idStr)) {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请先选择要修改的医生');");
			out.write("location.href='selectdoctor';");
			out.write("</script>");
			out.close();
			return;
		}
		DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		List<Department> deplist = departmentServiceImpl.selectAll();
		Doctor doctor = doctorServiceImpl.selectDoctorById(Integer.valueOf(idStr));
		request.setAttribute("deplist",deplist);
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("updatedoctor.jsp").forward(request, response);
	}
}
