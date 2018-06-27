 package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wise.docplus.dto.Appointment;
import org.wise.docplus.dto.Patient;
import org.wise.docplus.dto.SlotTime;

public class AppointmentDAO {
	public Appointment getAppointment(int appointmentId) {
	PreparedStatement pst = null;
	ResultSet rst = null;
	Appointment appointment = null;
	Patient patient = null;
	SlotTime time = null;
final String SELECT_QUERY = "select * from appointment where appointmentId = ?";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setLong(1, appointmentId);
	rst = pst.executeQuery();
	if(rst.next()){
		appointment = new Appointment();
		patient =new Patient();
		time = new SlotTime();
		patient.setId(rst.getInt(1));
		time.setSerialNumber(rst.getInt(2));
		appointment.setPatientId(patient.getId());
		appointment.setSerialNumber(time.getSerialNumber());
		
	System.out.println(appointment);
	}
} catch (SQLException e) {
	e.printStackTrace();
}finally{
	DBConnection.close(pst,rst);
}
return appointment ;
}
	
	public int add(Appointment appointment){
		final String INSERT_QUERY="insert into appointment(patientId,slotTimeSerialNumber) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(2, appointment.getPatientId());
			pst.setInt(3, appointment.getSerialNumber());
			
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
