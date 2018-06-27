package org.wise.docplus.dto;


public class Uploads {
	
	private String reports;
	private Patient patient;
	


	public String getReports() {
		return reports;
	}

	public void setReports(String reports) {
		this.reports = reports;
	}

	public int getId() {
		return patient.getId();
	}

	public void setId(int patientId) {
		patient.setId(patientId);
	}

	@Override
    public String toString() {
    	return "uploads [, reports=" + reports + ",Patient_id=" + patient.getId() + "]";
    	
   }

	
}
