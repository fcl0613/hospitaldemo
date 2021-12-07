package com.hospital.servlet.manage.doctor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Department;
import com.hospital.service.manage.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class ToAddDoctor
 */
@WebServlet("/manage/toadddoctor")
public class ToAddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
		List<Department> list = departmentServiceImpl.selectAll();
		request.setAttribute("deplist", list);
		request.getRequestDispatcher("adddoctor.jsp").forward(request, response);
	}
}
