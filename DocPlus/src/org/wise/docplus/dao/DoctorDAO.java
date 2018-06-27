package org.wise.docplus.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import org.wise.docplus.dto.Doctor;
import org.wise.docplus.dto.Hospital;





public class DoctorDAO {
	
	public Doctor getDoctor(String userName, String password) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Doctor doctor=null;
	final String SELECT_QUERY = "select * from Doctor where userName = ? and password = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, userName);
		pst.setString(2, password);
		rst = pst.executeQuery();
		if(rst.next()){
			doctor = new Doctor();
			doctor.setId(rst.getInt(1));
			doctor.setFullName(rst.getString(2));
			doctor.setDob(rst.getDate(3));
			doctor.setGender(rst.getString(4));
			doctor.setEmail(rst.getString(5));
			doctor.setUserName(rst.getString(6));
			doctor.setPassword(rst.getString(7));
			doctor.setPractisingFrom(rst.getDate(8));
			doctor.setSpecialisation(rst.getString(9));
			doctor.setDescription(rst.getString(10));
			doctor.setHouseNumber(rst.getString(11));
			doctor.setStreet(rst.getString(12));
			doctor.setCity(rst.getString(13));
			doctor.setState(rst.getString(14));
			doctor.setCountry(rst.getString(15));
			doctor.setContact(rst.getString(16));
		System.out.println(doctor);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBConnection.close(pst,rst);
	}
	System.out.println("doctor is in dao:"+doctor);
	return doctor ;
	}
	
	public int add(Doctor doctor){
		final String INSERT_QUERY="insert into Doctor(full_Name,dob,gender,email,userName,password,practising_from,specialization,description,house_number,street,city,state,country,contact) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			
			pst.setString(1, doctor.getFullName());
			pst.setDate(2, new java.sql.Date(doctor.getDob().getTime()));
			pst.setString(3, doctor.getGender());
			pst.setString(4,doctor.getEmail());
			pst.setString(5,doctor.getUserName());
			pst.setString(6,doctor.getPassword());
			pst.setDate(7, new java.sql.Date(doctor.getPractisingFrom().getTime()));
			pst.setString(8,doctor.getSpecialisation());
			pst.setString(9, doctor.getDescription());
			pst.setString(10,doctor.getHouseNumber());
			pst.setString(11, doctor.getStreet());
			pst.setString(12, doctor.getCity());
			pst.setString(13, doctor.getState());
			pst.setString(14, doctor.getCountry());
			pst.setString(15, doctor.getContact());
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
		final String SELECT_QUERY = "delete from doctor where username = ?";
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
	
	public int editDoctor(Doctor doctor) {
		Connection con = null;
		PreparedStatement pst = null;
		int x = 0;
			try {
				con = DBConnection.getConnection();
				pst = con.prepareStatement("update doctor set fullName= ?, dob= ?,gender = ?, email = ?, userName=?, password=?,practising_from = ?,specialiasation = ?,description = ?,house_number = ?,street = ?,city = ?,state = ? ,country = ?,contact = ?  where id = ?");
				pst.setInt(16, doctor.getId());
				pst.setString(1, doctor.getFullName());
				pst.setDate(2,  new java.sql.Date(doctor.getDob().getTime()));
				pst.setString(3, doctor.getGender());
				pst.setString(4, doctor.getEmail());
				pst.setString(5,doctor.getUserName());
				pst.setString(6,doctor.getPassword());
				pst.setDate(7,new java.sql.Date(doctor.getPractisingFrom().getTime()));
				pst.setString(8,doctor.getSpecialisation());
				pst.setString(9,doctor.getDescription());
				pst.setString(10,doctor.getHouseNumber());
				pst.setString(11,doctor.getStreet());
				pst.setString(12,doctor.getCity());
				pst.setString(13,doctor.getState());
				pst.setString(14,doctor.getCountry());
				pst.setString(15,doctor.getContact());
				
				x = pst.executeUpdate();
				System.out.println("Inside Update....."+doctor);
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
	
	public List<Hospital> getHospitalList(int id) {
		List<Hospital> list = new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select h.id, h.hospital_name from Hospital h, Doctor D where h.Doctor_id = D.id and Doctor_id = ?";
	try(Connection con = DBConnection.getConnection();){
		pst=con.prepareStatement(SELECT_QUERY);

		pst.setInt(1,id);

		rst = pst.executeQuery();
		while(rst.next()) {
			Hospital hospital = new Hospital();
			hospital.setId(rst.getInt(1));
			hospital.setName(rst.getString(2));
			list.add(hospital);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	System.out.println("list"+list);
	return list;
		
	}

}
