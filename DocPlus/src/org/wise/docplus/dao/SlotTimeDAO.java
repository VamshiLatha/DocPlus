package org.wise.docplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.wise.docplus.dto.DayOfWeek;
import org.wise.docplus.dto.PatientReview;
import org.wise.docplus.dto.SlotTime;

public class SlotTimeDAO {
	public SlotTime getTime(int appointmentId) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		SlotTime  time = null;
	final String SELECT_QUERY = "select * from slot_time where appointmentId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setLong(1, appointmentId);
		rst = pst.executeQuery();
		if(rst.next()){
			time = new SlotTime();
			DayOfWeek day = new DayOfWeek();
			day.setWeekId(rst.getInt(1));
			time.setWeekId(day.getWeekId());
			time.setSerialNumber(rst.getInt(1));
			time.setSlot(rst.getString(2));
			time.setStartTime(rst.getString(3));
			time.setEndTime(rst.getString(4));


			
		System.out.println(time);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBConnection.close(pst,rst);
	}
	return time;
	}
	
	public int add(SlotTime slotTime){
		final String INSERT_QUERY="insert into doctor(slot,startTime,endTime,dayOfWeekId) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			
			pst.setString(2, slotTime.getSlot());
			pst.setString(3, slotTime.getStartTime());
			pst.setString(4, slotTime.getEndTime());
			pst.setInt(5,slotTime.getWeekId());
			
		
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
