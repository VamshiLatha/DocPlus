package org.wise.docplus.dto;

import java.util.Date;

public class PatientReview {
	private int id;
	private String isReviewAnonymous;
	private String review;
	private String isDoctorRecommended;
	private Date reviewDate;
	private int consultedDoctorId;
	
	
   


	public String getIsReviewAnonymous() {
		return isReviewAnonymous;
	}


	public void setIsReviewAnonymous(String isReviewAnonymous) {
		this.isReviewAnonymous = isReviewAnonymous;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getIsDoctorRecommended() {
		return isDoctorRecommended;
	}


	public void setIsDoctorRecommended(String isDoctorRecommended) {
		this.isDoctorRecommended = isDoctorRecommended;
	}


	public Date getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}


	public int getConsultedDoctorId() {
		return consultedDoctorId;
	}


	public void setConsultedDoctorId(int consultedDoctorId) {
		this.consultedDoctorId = consultedDoctorId;
	}


	@Override
    public String toString() {
    	return "Patient_Review [is_review_anonymous=" + isReviewAnonymous + ", review=" + review + ", is_doctor_recommended=" + isDoctorRecommended +", review_date=" + reviewDate + ", consulted_doctor_id=" + consultedDoctorId + "]";
    	
   }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
