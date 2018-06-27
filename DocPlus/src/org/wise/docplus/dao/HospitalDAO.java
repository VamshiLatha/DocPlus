package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wise.docplus.dto.Doctor;
import org.wise.docplus.dto.Hospital;


public class HospitalDAO {
	public Hospital getHospital(String hospitalName, int hospitalId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Hospital hospital =null;
		Doctor doctor= null;
	final String SELECT_QUERY = "select * from Hospital where hospitalName = ? ";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, hospitalName);
		pst.setLong(2, hospitalId);
		rst = pst.executeQuery();
		if(rst.next()){
			hospital=new Hospital();
			hospital.setId(rst.getInt(1));
			hospital.setName(rst.getString(2));
			hospital.setSurveyNumber(rst.getString(3));
			hospital.setStreet(rst.getString(4));
			hospital.setCity(rst.getString(5));
			hospital.setState(rst.getString(6));
			hospital.setCountry(rst.getString(7));
			hospital.setPincode(rst.getString(8));
			hospital.setStartDate(rst.getDate(9));
			hospital.setEndDate(rst.getDate(10));
			doctor.setId(rst.getInt(1));
			hospital.setDoctor(doctor);
			
			hospital.setConsultationFee(rst.getDouble(10));
		System.out.println(hospital);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBConnection.close(pst,rst);
	}
	return hospital ;
	}
	
	
	public int add(Hospital hospital){
		final String INSERT_QUERY="insert into Hospital(Doctor_id,hospital_name,survey_number,street,city,pincode,state,country,consultation_fee) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, hospital.getDoctor().getId());
			pst.setString(2, hospital.getName());
			pst.setString(3,hospital.getSurveyNumber());
			pst.setString(4,hospital.getStreet());
			pst.setString(5,hospital.getCity());
			pst.setString(6,hospital.getPincode());
			pst.setString(7,hospital.getState());
			pst.setString(8, hospital.getCountry());
			pst.setDouble(9, hospital.getConsultationFee());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(pst);
		}
		return status ;
	}
	
	public  void delete(int hospitalId) {
		Connection con = null;
		PreparedStatement pst = null;
		final String SELECT_QUERY = "delete from Hospital where username = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1,hospitalId);
			pst.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}finally{
			DBConnection.close(pst,con);
		}
		
	}public int editHospital(Hospital hospital) {
		Connection con = null;
		PreparedStatement pst = null;
		int x = 0;
			try {
				con = DBConnection.getConnection();
				pst = con.prepareStatement("update doctor set hospitalName= ?, surveyNumber= ?, street = ?,city = ?,state = ? ,country = ?,pincode = ?  where id = ?");
				pst.setInt(16, hospital.getId());
				pst.setString(1, hospital.getName());
				pst.setString(2,hospital.getSurveyNumber());
				pst.setString(3,hospital.getStreet());
				pst.setString(4,hospital.getCity());
				pst.setString(5,hospital.getState());
				pst.setString(6,hospital.getCountry());
				pst.setString(7,hospital.getPincode());
				pst.setDate(8,new java.sql.Date(hospital.getStartDate().getTime()));
				pst.setDate(9,new java.sql.Date(hospital.getEndDate().getTime()));
				
				
				x = pst.executeUpdate();
				System.out.println("Inside Update....."+hospital);
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
	
	/*public Hospital getHospitalid(String name) {
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Hospital hospital = null;
	final String SELECT_QUERY = "select h.id from Hospital h, Doctor D where h.id = h.hospital_name";
	try(Connection con = DBConnection.getConnection();){
		pst=con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()) {
			hospital = new Hospital();
			hospital.setId(rst.getInt(1));
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return hospital;
		
	}*/

	
}
