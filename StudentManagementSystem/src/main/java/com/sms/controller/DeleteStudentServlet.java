package com.sms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.sms.dao.StudentDAO;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/DeleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long sid=Long.parseLong(request.getParameter("id"));
		
		//create obj for studentdao and call deletebyid method
		StudentDAO sdao=new StudentDAO();
		int result=sdao.deleteStudentById(sid);
		
		if(result==1) {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("deleteMsg", sid+" student record is deleted");
		}else {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("deleteMsg", sid+" student record is not deleted");
		}
		response.sendRedirect("GetAllStudents");
		
	}

}
