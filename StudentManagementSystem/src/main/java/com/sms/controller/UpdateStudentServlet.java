package com.sms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.sms.dao.StudentDAO;
import com.sms.model.StudentBean;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//read the updated student values
		Long id=Long.parseLong(request.getParameter("id"));
		String firstName=(request.getParameter("firstName"));
		String lastName=(request.getParameter("lastName"));
		String email=(request.getParameter("email"));
		String phone=(request.getParameter("phone"));
		String department=(request.getParameter("department"));
		String city=(request.getParameter("city"));
		
		// store the above values into a student bean
		StudentBean sb=new StudentBean();
		sb.setId(id);
		sb.setFirstname(firstName);
		sb.setLastname(lastName);
		sb.setEmail(email);
		sb.setPhone(phone);
		sb.setDepartment(department);
		sb.setCity(city);
		
		//create obj for sdao and class updatestudent method
		StudentDAO sdao=new StudentDAO();
		int result=sdao.updateStudent(sb);
		if(result>0) {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("updateMsg",sb.getFirstname()+" student details updated successfully");
		}else {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("updateMsg",sb.getFirstname()+" student details updation failed");
		}
		response.sendRedirect("GetAllStudents");
	}

}
