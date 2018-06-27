package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wise.docplus.dto.Appointment;
import org.wise.docplus.dto.AppointmentStatus;
import org.wise.docplus.dto.Doctor;



public class AppointmentStatusDAO {
	public AppointmentStatus getStatus(int appointmentId) {
	PreparedStatement pst = null;
	ResultSet rst = null;
	AppointmentStatus status = null;
	
	Doctor doctor = null;
final String SELECT_QUERY = "select * from appointment_status where appointmentId = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setLong(1, appointmentId);
	rst = pst.executeQuery();
	if(rst.next()){
		status = new AppointmentStatus();
		doctor = new Doctor();
		Appointment appointmentid = new Appointment();
		appointmentid.setAppointmentId(rst.getInt(1));
		doctor.setId(rst.getInt(1));
		status.setBooked(rst.getString(2));
		status.setAppointmentid(appointmentid.getAppointmentId());


	System.out.println(status);
	}
} catch (SQLException e) {
	e.printStackTrace();
}finally{
	DBConnection.close(pst,rst);
}
return status ;
}
	public int add(AppointmentStatus appointmentStatus){
		final String INSERT_QUERY="insert into appointmentstatus(appointmentId,doctorId,isBooked) values(?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, appointmentStatus.getAppointmentid());
			pst.setInt(2, appointmentStatus.getDoctorId());
			pst.setString(3, appointmentStatus.getBooked());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(pst);
		}
		return status ;
	}
	
	public  void delete(int appointmentId) {
		Connection con = null;
		PreparedStatement pst = null;
		final String SELECT_QUERY = "delete from doctor where username = ?";
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, appointmentId);
			pst.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}finally{
			DBConnection.close(pst,con);
		}
		
	}
}
