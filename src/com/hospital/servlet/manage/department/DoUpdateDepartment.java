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
 * Servlet implementation class DoUpdateDepartment
 */
@WebServlet("/manage/doupdatedepartment")
public class DoUpdateDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depidStr = request.getParameter("depid");
		String location = request.getParameter("location");
		String desc = request.getParameter("desc");
		if (depidStr != null && !"".equals(depidStr)) {
			Department department = new Department(Integer.valueOf(depidStr),null,null,location,desc,null);
			DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
			int res = departmentServiceImpl.updateDepartment(department);
			PrintWriter out = response.getWriter();
			if (res > 0) {
				out.write("<script>");
				out.write("alert('科室修改成功');");
				out.write("location.href='selectalldepartment';");
				out.write("</script>");
			}else {
				out.write("<script>");
				out.write("alert('科室修改失败');");
				out.write("location.href='toupdatedepartment';");
				out.write("</script>");
			}
			out.close();
		}else {
			return;
		}
		
	}

}
