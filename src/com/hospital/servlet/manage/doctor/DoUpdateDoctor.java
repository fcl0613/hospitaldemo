package com.hospital.servlet.manage.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.entity.Career;
import com.hospital.entity.Department;
import com.hospital.entity.Doctor;
import com.hospital.service.manage.impl.DoctorServiceImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class DoUpdateDoctor
 */
@WebServlet("/manage/doupdatedoctor")
public class DoUpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建SmartUploadd对象
		SmartUpload su = new SmartUpload();
		//初始化
		su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取上传的文件对象
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		String filename = f.getFileName();
		if (filename != null && !"".equals(filename)) {
			try {
				su.save("/pic");
				f.saveAs("/pic"+filename);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(filename);
		Request req = su.getRequest();
		String pic = req.getParameter("picture");
		if (filename == null || "".equals(filename)) {
			filename = pic;
		}
		String didStr = req.getParameter("did");
		String account = req.getParameter("account");
		String dname = req.getParameter("dname");
		String grendStr = req.getParameter("gender");
		String feeStr = req.getParameter("fee");
		String ageStr = req.getParameter("age");
		String description = req.getParameter("description");
		String careerStr = req.getParameter("car");
		String depStr = req.getParameter("dep");
		String regStr = req.getParameter("reg");
		Doctor doctor = new Doctor(Integer.valueOf(didStr),
				account,
				null,
				dname,
				Integer.valueOf(grendStr),
				Double.valueOf(feeStr),
				Integer.valueOf(ageStr),
				description,
				filename,
				new Career(Integer.valueOf(careerStr)),
				new Department(Integer.valueOf(depStr)),
				Integer.valueOf(regStr),
				0);
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		int res = doctorServiceImpl.updateDoctor(doctor);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('信息更新成功');");
			out.write("location.href='selectdoctor';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('信息更新失败');");
			out.write("location.href='toupdatedoctor?did="+didStr+"';");
			out.write("</script>");
		}
		out.close();
	}

}
