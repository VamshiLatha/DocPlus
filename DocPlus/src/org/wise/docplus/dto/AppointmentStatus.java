package org.wise.docplus.dto;


public class AppointmentStatus {
	private Appointment appointment;
	private Doctor doctor;
	private String isBooked;
	
	
	
	public int getAppointmentid() {
		return appointment.getAppointmentId();
	}

	public void setAppointmentid(int appointmentId) {
		this.appointment.setAppointmentId(appointmentId);
	}
	public int getDoctorId() {
		return doctor.getId();
	}


	public void setId(int id) {
		this.doctor.setId(id);
	}


	public String getBooked() {
		return isBooked;
	}


	public void setBooked(String isBooked) {
		this.isBooked = isBooked;
	}


	@Override
    public String toString() {
    	return "appointment_status [ Doctor_id=" + doctor.getId() + ",booked=" + isBooked + "]";
    	
   }


	
	
}
