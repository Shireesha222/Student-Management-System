package com.sms.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.sms.dao.StudentDAO;
import com.sms.model.StudentBean;

/**
 * Servlet implementation class GetAllStudents
 */
@WebServlet("/GetAllStudents")
public class GetAllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StudentBean> studentList=new ArrayList<StudentBean>();
		StudentDAO sd=new StudentDAO();
		studentList=sd.getAllStudents();
		request.setAttribute("studentList",studentList);
		RequestDispatcher rd=request.getRequestDispatcher("display-student.jsp");
		rd.forward(request, response);
	}

}
