package com.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	 private static final String URL =
	            "jdbc:mysql://localhost:3306/sms_db";

	    private static final String USERNAME = "root";

	    private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";

	    private static Connection con;

	
	private DBConnection() {
    }


	public static Connection getConnection() {
		if (con == null) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        URL,
                        USERNAME,
                        PASSWORD
                );

                System.out.println("Database connected successfully!");
                
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }
		 return con; 
	
	}
    public static void main(String[] args) {
        getConnection();
    }
}


