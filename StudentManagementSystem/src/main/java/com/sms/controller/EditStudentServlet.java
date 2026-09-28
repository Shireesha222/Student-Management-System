package com.sms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sms.dao.StudentDAO;
import com.sms.model.StudentBean;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/EditStudent")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read student id
		Long id=Long.parseLong(request.getParameter("id"));
		
		StudentDAO sdao=new StudentDAO();
		StudentBean sb=sdao.getStudentById(id);
		
		request.setAttribute("s", sb);
		request.getRequestDispatcher("edit-student.jsp").forward(request, response);
	}

}
