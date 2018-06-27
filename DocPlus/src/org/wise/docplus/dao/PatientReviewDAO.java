package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wise.docplus.dto.AppointmentStatus;
import org.wise.docplus.dto.Doctor;
import org.wise.docplus.dto.PatientReview;

public class PatientReviewDAO {
	public PatientReview getReview(int consultedDoctorId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		PatientReview  review = null;
	final String SELECT_QUERY = "select * from patient_review where appointmentId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setLong(1, consultedDoctorId);
		rst = pst.executeQuery();
		if(rst.next()){
			review = new PatientReview();
			review.setIsReviewAnonymous(rst.getString(2));
			review.setReview(rst.getString(3));
			review.setIsDoctorRecommended(rst.getString(4));
			review.setReviewDate(rst.getDate(5));
			review.setConsultedDoctorId(rst.getInt(6));
		System.out.println(review);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBConnection.close(pst,rst);
	}
	return review;
	}
	
	public int add(PatientReview review){
		final String INSERT_QUERY="insert into doctor(isReviewAnonymous,review,isDoctorRecommended,reviewDate,consultedDoctorId) values(?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			
			pst.setString(2, review.getIsReviewAnonymous());
			pst.setString(3, review.getReview());
			pst.setString(4, review.getIsDoctorRecommended());
			pst.setDate(5,new java.sql.Date(review.getReviewDate().getTime()));
			pst.setInt(6,review.getConsultedDoctorId());
		
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
