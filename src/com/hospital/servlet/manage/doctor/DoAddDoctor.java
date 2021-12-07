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
 * Servlet implementation class DoAddDoctor
 */
@WebServlet("/manage/doadddoctor")
public class DoAddDoctor extends HttpServlet {
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
		Request req = su.getRequest();
		String account = req.getParameter("account");
		String dname = req.getParameter("dname");
		String genderStr = req.getParameter("gender");
		String fee = req.getParameter("fee");
		String age = req.getParameter("age");
		String description = req.getParameter("description");
		String careerStr = req.getParameter("car");
		String depStr = req.getParameter("dep");
		String registerStr = req.getParameter("reg");
		Doctor doctor = new Doctor(null, account, null, dname, Integer.valueOf(genderStr),
				Double.valueOf(fee),
				Integer.valueOf(age),
				description,
				filename, 
				new Career(Integer.valueOf(careerStr)),
				new Department(Integer.valueOf(depStr)),
				Integer.valueOf(registerStr),
				0);
		DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl();
		int res = doctorServiceImpl.addDoctor(doctor);
		PrintWriter out = response.getWriter();
		if (res > 0) {
			out.write("<script>");
			out.write("alert('添加成功');");
			out.write("location.href='toadddoctor';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('添加失败');");
			out.write("location.href='toadddoctor';");
			out.write("</script>");
		}
		out.close();
	}

}
