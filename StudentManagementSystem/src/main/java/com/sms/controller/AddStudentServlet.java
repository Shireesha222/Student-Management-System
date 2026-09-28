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
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// store all form details
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String department=request.getParameter("department");
		String city=request.getParameter("city");
		
		//create a student bean and store the values
		StudentBean sb=new StudentBean();
		sb.setFirstname(firstName);
		sb.setLastname(lastName);
		sb.setEmail(email);
		sb.setPhone(phone);
		sb.setDepartment(department);
		sb.setCity(city);
		
		//create obj for student dao
		StudentDAO sdao=new StudentDAO();
		int result=sdao.addStudent(sb);
		
		if(result>0) {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("insertMsg",sb.getFirstname()+" details inserted successfully");
			response.sendRedirect("GetAllStudents");
			
		}else {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("insertMsg", "insertion is failed");
			response.sendRedirect("add-student.jsp");
		}
		
		
	}

}
