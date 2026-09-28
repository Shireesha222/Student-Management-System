package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sms.model.StudentBean;
import com.sms.util.DBConnection;

public class StudentDAO {
	//method returns all student records
	public ArrayList<StudentBean> getAllStudents(){
		// create arraylist to store student records
		ArrayList<StudentBean> stdList=new ArrayList();
		StudentBean sb=null;
		//create connection with db
		Connection con=DBConnection.getConnection();
		String query="select id,first_name,last_name,email,phone,department,city FROM student_details";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				sb=new StudentBean();
				sb.setId(rs.getLong(1));
				sb.setFirstname(rs.getString(2));
				sb.setLastname(rs.getString(3));
				sb.setEmail(rs.getString(4));
				sb.setPhone(rs.getString(5));
				sb.setDepartment(rs.getString(6));
				sb.setCity(rs.getString(7));
				stdList.add(sb);

				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stdList;
		
		
	}//end of the method
	
	//this method insert student record into db
	public int addStudent(StudentBean sb) {
		int result=0;
		String query="insert into student_details(first_name,last_name,email,phone,department,city) values(?,?,?,?,?,?)";
		//create con
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, sb.getFirstname());
			ps.setString(2, sb.getLastname());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getPhone());
			ps.setString(5, sb.getDepartment());
			ps.setString(6, sb.getCity());
			
			result=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}//end of method
	
	//this method return student record based on student id
	public StudentBean getStudentById(Long id) {
		StudentBean sb=null;
		String query="select * from student_details where id=?";
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sb=new StudentBean();
				sb.setId(rs.getLong(1));
				sb.setFirstname(rs.getString(2));
				sb.setLastname(rs.getString(3));
				sb.setEmail(rs.getString(4));
				sb.setPhone(rs.getString(5));
				sb.setDepartment(rs.getString(6));
				sb.setCity(rs.getString(7));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	} //end of method
	
	//this method update student details in db
	public int updateStudent(StudentBean sb) {
		int result=0;
		String query="update student_details set first_name=?,last_name=?,email=?,phone=?,department=?,city=? where id=?";
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,sb.getFirstname());
			ps.setString(2,sb.getLastname());
			ps.setString(3,sb.getEmail());
			ps.setString(4,sb.getPhone());
			ps.setString(5,sb.getDepartment());
			ps.setString(6,sb.getCity());
			ps.setLong(7, sb.getId());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}//end of method
	
	//this method deletes student record based on id
    public int deleteStudentById(Long sid) {
    	int result=0;
    	Connection con=DBConnection.getConnection();
    	String query="delete from student_details where id= ?";
    	try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1, sid);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }

}
