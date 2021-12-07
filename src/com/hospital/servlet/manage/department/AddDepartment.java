package com.hospital.servlet.manage.department;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Department;
import com.hospital.service.manage.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class AddDepartment
 */
@WebServlet("/manage/adddepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depname = request.getParameter("depname");
		String typeStr = request.getParameter("type");
		String location = request.getParameter("location");
		String describe = request.getParameter("desc");
		if (typeStr != null && !"".equals(typeStr)) {
			Department department = new Department(null,depname,Integer.valueOf(typeStr),location,describe,0);
			DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
			int res = departmentServiceImpl.addDepartment(department);
			PrintWriter out = response.getWriter();
			if (res > 0) {
				out.write("<script>");
				out.write("alert('科室添加成功');");
				out.write("location.href='adddepartment.jsp';");
				out.write("</script>");
			}else {
				out.write("<script>");
				out.write("alert('科室添加失败');");
				out.write("location.href='adddepartment.jsp';");
				out.write("</script>");
			}
			out.close();
		}else {
			return;
		}
	}

}
