package org.wise.docplus.dto;

public class Appointment {
	private int id;
	private Patient patient;
	private SlotTime slotTime;
	
	public int getAppointmentId() {
		return id;
	}



	public void setAppointmentId(int id) {
		this.id = id;
	}
	
	

	public int getSerialNumber() {
		return slotTime.getSerialNumber();
	}



	public void setSerialNumber(int serialNumber) {
		this.slotTime.setSerialNumber(serialNumber); 
	}



	@Override
    public String toString() {
    	return "appointment [ AppointmetId = "+id+",Patient_id=" + patient.getId() + ",Slot_time_Serial_number=" + slotTime.getSerialNumber() + "]";
    	
   }



	public int getPatientId() {
		return patient.getId();
	}



	public void setPatientId(int patientId) {
		this.patient.setId(patientId);;
	}




}
