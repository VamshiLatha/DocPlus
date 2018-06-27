package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wise.docplus.dto.DayOfWeek;
import org.wise.docplus.dto.Hospital;

public class DayOfWeekDAO {
	public DayOfWeek getDay(int hospitalId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		DayOfWeek date = null;
	final String SELECT_QUERY = "select * from Day_of_week where Hospital_id = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, hospitalId);
		rst = pst.executeQuery();
		if(rst.next()){
			date = new DayOfWeek();
			Hospital hospital = new Hospital();
			hospital.setId(rst.getInt(1));
			date.setHospital(hospital);
			date.setWeekId(rst.getInt(1));
			date.setSelectdate(rst.getDate(2));
			

			
		System.out.println(date);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBConnection.close(pst,rst);
	}
	return date ;
	}
	
	public int add(DayOfWeek day){
		final String INSERT_QUERY="insert into Day_of_week(selected_date,Hospital_id) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setDate(1,  new java.sql.Date( day.getSelectdate().getTime()));
			pst.setInt(2, day.getHospital().getId());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(pst);
		}
		return status ;
	}
	
	public  void delete(int weekId) {
		Connection con = null;
		PreparedStatement pst = null;
		final String SELECT_QUERY = "delete from doctor where username = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, weekId);
			pst.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}finally{
			DBConnection.close(pst,con);
		}
		
	}
}
