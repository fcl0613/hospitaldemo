package com.hospital.servlet.manage.department;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.service.manage.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class DeleteDepartment
 */
@WebServlet("/manage/deletedepartment")
public class DeleteDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("depid");
		PrintWriter out = response.getWriter();
		if (idStr != null && !"".equals(idStr)) {
			Integer id = Integer.valueOf(idStr);
			DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
			int res = departmentServiceImpl.deleteDepartment(id);
			if (res > 0) {
				out.write("<script>");
				out.write("alert('删除成功');");
			}else {
				out.write("<script>");
				out.write("alert('删除失败');");
			}
			out.write("location.href='selectalldepartment';");
			out.write("</script>");
			out.close();
		}else {
			out.write("<script>");
			out.write("alert('请选择要删除对象');");
			out.write("location.href='selectalldepartment';");
			out.write("</script>");
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] IdStr = request.getParameterValues("id[]");
		DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
		int res = 0;
		if (IdStr != null && IdStr.length > 0) {
			for (int i = 0; i < IdStr.length; i++) {
				Integer id = Integer.valueOf(IdStr[i]);
				if (id != null) {
					res += departmentServiceImpl.deleteDepartment(id);
				}
			}
			if (res>0) {
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('删除成功');");
				out.write("location.href='selectalldepartment';");
				out.write("</script>");
				out.close();
			}else {
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('删除失败');");
				out.write("location.href='selectalldepartment';");
				out.write("</script>");
				out.close();
			}
			response.sendRedirect("/hospital/manage/selectalldepartment");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('请选择要删除对象');");
			out.write("location.href='selectalldepartment';");
			out.write("</script>");
			out.close();
		}
	}

}
