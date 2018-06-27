package org.wise.docplus.dto;

public class SlotTime {
	private int serialNumber;
	private String slot;
	private String startTime;
	private String endTime;
	private DayOfWeek dayOfWeek;
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	

	@Override
    public String toString() {
    	return "slot_time [serial_number=" + serialNumber +", slot=" + slot + ",start_time=" + startTime + ", end_time=" + endTime + ",day_of_week_id ="+dayOfWeek+" ]";
    	
   }

	public int getWeekId() {
		return dayOfWeek.getWeekId();
	}

	public void setWeekId(int weekId) {
		dayOfWeek.setWeekId( weekId);
	}
}
