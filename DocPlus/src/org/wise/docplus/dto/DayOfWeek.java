package org.wise.docplus.dto;

import java.util.Date;
public class DayOfWeek {
	
	private int weekId;
	private Date selectdate;
	private Hospital hospital;
	public int getWeekId() {
		return weekId;
	}
	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}
	public Date getSelectdate() {
		return selectdate;
	}
	public void setSelectdate(Date selectdate) {
		this.selectdate = selectdate;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	/*public int getWeekId() {
		return weekId;
	}

	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}
	
	public Date getSelectdate() {
		return selectdate;
	}

	public void setSelectdate(Date selectdate) {
		this.selectdate = selectdate;
	}

	public int getHospitalId() {
		return hospital.getId();
	}

	public void setHospitalId(int id) {
		hospital.setId(id); 
	}*/

	@Override
    public String toString() {
    	return "day_of_week [ WeekId = "+weekId+", Hospital_id=" + hospital.getId() + ",Select_date=" + selectdate + "]";
    	
   }

	
}
