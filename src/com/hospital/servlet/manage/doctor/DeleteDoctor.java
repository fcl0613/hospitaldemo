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
 * Servlet implementation class DeleteDoctor
 */
@WebServlet("/manage/deletedoctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("did");
		if (idStr == null || "".equals(idStr)) {
			return;
		}
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		int res = doctorServiceImpl.delectDoctor(Integer.valueOf(idStr));
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('删除成功');");
			out.write("location.href='selectdoctor';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('删除失败');");
			out.write("location.href='selectdoctor';");
			out.write("</script>");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] IdStr = request.getParameterValues("id[]");
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		int res = 0;
		if (IdStr != null && IdStr.length > 0) {
			for (int i = 0; i < IdStr.length; i++) {
				Integer id = Integer.valueOf(IdStr[i]);
				if (id != null) {
					res += doctorServiceImpl.delectDoctor(id);
				}
			}
			if (res>0) {
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('删除成功');");
				out.write("location.href='selectdoctor';");
				out.write("</script>");
				out.close();
			}else {
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('删除失败');");
				out.write("location.href='selectdoctor';");
				out.write("</script>");
				out.close();
			}
//			response.sendRedirect("/hospital/manage/selectdoctor");
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
