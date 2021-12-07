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
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UpdateGrxx
 */
@WebServlet("/doctor/updategrxx")
public class UpdateGrxx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建SmartUploadd对象
		SmartUpload su = new SmartUpload();
		// 初始化
		su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取上传的文件对象
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		String filename = f.getFileName();
		if (filename != null && !"".equals(filename)) {
			try {
				su.save("/pic");
				f.saveAs("/pic" + filename);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Request req = su.getRequest();
		String pic = req.getParameter("picture");
		if (filename == null || "".equals(filename)) {
			filename = pic;
		}
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor");
		String dname = req.getParameter("dname");
		String grendStr = req.getParameter("gender");
		String ageStr = req.getParameter("age");
		String description = req.getParameter("description");
		Doctor ndoctor = new Doctor(doctor.getId(),dname, Integer.valueOf(grendStr),
				 Integer.valueOf(ageStr), description, filename);
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		int res = doctorServiceImpl.updateGrxx(ndoctor);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('信息更新成功');");
			out.write("location.href='selectsche';");
			out.write("</script>");
		} else {
			out.write("<script>");
			out.write("alert('信息更新失败');");
			out.write("location.href='selectgrxinxi';");
			out.write("</script>");
		}
		out.close();
	}

}
