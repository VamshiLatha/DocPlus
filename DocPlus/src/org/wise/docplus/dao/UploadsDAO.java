package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wise.docplus.dto.Patient;
import org.wise.docplus.dto.PatientReview;
import org.wise.docplus.dto.Uploads;

public class UploadsDAO {
	public Uploads getUploads(int patientId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		Uploads  upload = null;
	final String SELECT_QUERY = "select * from uploads where appointmentId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setLong(1, patientId);
		rst = pst.executeQuery();
		if(rst.next()){
			upload = new Uploads();
			Patient patient = new Patient();
			patient.setId(rst.getInt(1));
			upload.setReports(rst.getString(2));
			upload.setId(patient.getId());
		
		System.out.println(upload);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBConnection.close(pst,rst);
	}
	return upload;
	}
	
	public int add(Uploads upload){
		final String INSERT_QUERY="insert into doctor(reports,patientId) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(2, upload.getReports());
			pst.setInt(3, upload.getId());
			
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
}
