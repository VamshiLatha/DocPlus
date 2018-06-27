package org.wise.docplus.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DocPlus","root","password");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Object ...args){
		try{
			
		for(Object k:args){
			if(k instanceof ResultSet)
				((ResultSet) k).close();
			else if(k instanceof Statement)
				((Statement) k).close();
			else if(k instanceof PreparedStatement)
				((Statement) k).close();
			else if(k instanceof Connection)
				((Connection) k).close();
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static java.util.Date date(String dob) {

		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			
			utilDate = sdf.parse(dob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return utilDate;
	}
}
