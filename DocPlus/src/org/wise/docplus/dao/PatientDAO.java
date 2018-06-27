package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wise.docplus.dto.Doctor;
import org.wise.docplus.dto.Patient;

public class PatientDAO {
	public Patient getPatient(String userName, String password) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Patient patient =null;
	final String SELECT_QUERY = "select * from Patient where userName = ? and password = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, userName);
		pst.setString(2, password);
		rst = pst.executeQuery();
		if(rst.next()){
			patient=new Patient();
			patient.setId(rst.getInt(1));
			patient.setFullName(rst.getString(2));
			patient.setDob(rst.getDate(3));
			patient.setGender(rst.getString(4));
			patient.setEmail(rst.getString(5));
			patient.setUserName(rst.getString(6));
			patient.setPassword(rst.getString(7));
			patient.setHouseNumber(rst.getString(8));
			patient.setStreet(rst.getString(9));
			patient.setCity(rst.getString(10));
			patient.setState(rst.getString(11));
			patient.setCountry(rst.getString(12));
			patient.setContact(rst.getString(13));
		System.out.println(patient);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBConnection.close(pst,rst);
	}
	return patient ;
	}
	
	public int add(Patient patient){
		final String INSERT_QUERY="insert into Patient(full_name,dob,gender,email,userName,password,house_number,street,city,state,country,contact) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, patient.getFullName());
			pst.setDate(2,  new java.sql.Date( patient.getDob().getTime()));
			pst.setString(3, patient.getGender());
			pst.setString(4,patient.getEmail());
			pst.setString(5,patient.getUserName());
			pst.setString(6,patient.getPassword());
			pst.setString(7,patient.getHouseNumber());
			pst.setString(8, patient.getStreet());
			pst.setString(9, patient.getCity());
			pst.setString(10, patient.getState());
			pst.setString(11, patient.getCountry());
			pst.setString(12, patient.getContact());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(pst);
		}
		return status ;
	}
	
	public  void delete(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		final String SELECT_QUERY = "delete from Patient where username = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, id);
			pst.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}finally{
			DBConnection.close(pst,con);
		}
		
	}
	
	public int editPatient(Patient patient) {
		Connection con = null;
		PreparedStatement pst = null;
		int x = 0;
			try {
				con = DBConnection.getConnection();
				pst = con.prepareStatement("update Patient set full_name= ?, dob= ?,gender = ?, email = ?, userName=?, password=?,house_number = ?,street = ?,city = ?,state = ? ,country = ?,contact = ?  where id = ?");
				pst.setInt(16, patient.getId());
				pst.setString(1, patient.getFullName());
				pst.setDate(2,  new java.sql.Date(patient.getDob().getTime()));
				pst.setString(3, patient.getGender());
				pst.setString(4, patient.getEmail());
				pst.setString(5,patient.getUserName());
				pst.setString(6,patient.getPassword());
				pst.setString(7,patient.getHouseNumber());
				pst.setString(8,patient.getStreet());
				pst.setString(9,patient.getCity());
				pst.setString(10,patient.getState());
				pst.setString(11,patient.getCountry());
				pst.setString(12,patient.getContact());
				
				x = pst.executeUpdate();
				System.out.println("Inside Update....."+patient);
			} catch (SQLException e) {				
				e.printStackTrace();
			}	
			finally{
				try {
					con.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			return x;
		}
}
