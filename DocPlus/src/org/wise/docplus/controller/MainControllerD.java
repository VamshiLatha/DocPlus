package org.wise.docplus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.wise.docplus.dao.DBConnection;
import org.wise.docplus.dao.DayOfWeekDAO;
import org.wise.docplus.dao.DoctorDAO;
import org.wise.docplus.dao.HospitalDAO;
import org.wise.docplus.dao.PatientDAO;
import org.wise.docplus.dto.DayOfWeek;
import org.wise.docplus.dto.Doctor;
import org.wise.docplus.dto.Hospital;
import org.wise.docplus.dto.Patient;



@WebServlet("/MainControllerD")
public class MainControllerD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("docRegister".equalsIgnoreCase(action)){
			registerDoctor(request).forward(request,response);
			return;
		} 
		
		/*else if(action.equalsIgnoreCase("select")) {
			slotDetails(request).forward(request, response);
		}*/
		
		if ("patientRegister".equalsIgnoreCase(action)) {
			registerPatient(request).forward(request,response);
			return;
		}

		
		if ("docLogin".equalsIgnoreCase(action)) {
			loginAsDoctor(request).forward(request,response);
			return;
		}
		
		if ("patientLogin".equalsIgnoreCase(action)) {
			loginAsPatient(request).forward(request,response);
		}
		
		if ("hospitalList".equalsIgnoreCase(action)) {
			listOfHospitals(request).forward(request, response);
			return;
		}
		
		if("hRegister".equalsIgnoreCase(action)) {
			hospitalRegister(request).forward(request,response);
			return;
		}
		
		
		
		
		if ("slot".equalsIgnoreCase(action)) {
			slotDetails(request).forward(request, response);
		}
		
		}
	
	
	


	public RequestDispatcher hospitalRegister(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		Doctor doctor=(Doctor)session.getAttribute("loggedUser");

		
		String hName = request.getParameter("hospitalName");
		String surveyNumber = request.getParameter("surveyNumber");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String consultFee = request.getParameter("consultation_fee");
		double consultationFee = Double.parseDouble(consultFee);

		
		Hospital hospital =new Hospital();
		HospitalDAO hospitalDAO = new HospitalDAO();
		
		hospital.setDoctor(doctor);
		hospital.setName(hName);
		hospital.setSurveyNumber(surveyNumber);
		hospital.setStreet(street);
		hospital.setCity(city);
		hospital.setPincode(pincode);
		hospital.setState(state);
		hospital.setCountry(country);
		hospital.setConsultationFee(consultationFee);
		
		System.out.println("console print:"+hospital);
		RequestDispatcher dispatcher=null;
		if(hospitalDAO.add(hospital)!=0){
			request.setAttribute("regStatus", "Registration Success.!");
			dispatcher = request.getRequestDispatcher("patient_profile.jsp");
		}
		return dispatcher;
	}





	private RequestDispatcher loginAsPatient(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		
		PatientDAO patientDAO = new PatientDAO();
		Patient patient = patientDAO.getPatient(userName, password);
		RequestDispatcher dispatcher=null;

		
		if(patient != null){
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", patient);
			dispatcher=request.getRequestDispatcher("home1.jsp");	
		}
		else{
			System.out.println("invalid");
			dispatcher=request.getRequestDispatcher("patientLogin.jsp");
		}
		return dispatcher;
	}





	public RequestDispatcher slotDetails(HttpServletRequest request) {
		RequestDispatcher dispatcher = null;
		DayOfWeekDAO dayOfWeekDAO = new DayOfWeekDAO();
		DayOfWeek dow = new DayOfWeek();
		
		String doa = request.getParameter("doa");
		Date ddate = DBConnection.date(doa);
		
		Hospital hospital = new Hospital();
		int id = Integer.parseInt(request.getParameter("hospId"));
		hospital.setId(id);
		System.out.println("print" + id);

		dow.setSelectdate(ddate);
		dow.setHospital(hospital);
		
		if(dayOfWeekDAO.add(dow)!= 0) {
			dispatcher = request.getRequestDispatcher("addSlots.jsp");

		} else {
			dispatcher = request.getRequestDispatcher("addSlots.jsp");
		}
		return dispatcher;
	}





	private RequestDispatcher listOfHospitals(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);
		Doctor doctor=(Doctor)session.getAttribute("loggedUser");
		DoctorDAO doctorDAO = new DoctorDAO();
		System.out.println("doctor id:"+doctor.getId());
		List<Hospital> list = doctorDAO.getHospitalList(doctor.getId());
		RequestDispatcher dispatcher=null;
	
		System.out.println("list" + list);
		dispatcher=request.getRequestDispatcher("slot.jsp");	
		request.setAttribute("hList", list);
		return dispatcher;
	}





	public RequestDispatcher loginAsDoctor(HttpServletRequest request) {
		String userName = request.getParameter("uName");
		String password = request.getParameter("psw");
		
		
		
		DoctorDAO doctorDAO = new DoctorDAO();
		Doctor doctor = doctorDAO.getDoctor(userName, password);
		RequestDispatcher dispatcher=null;

		System.out.println();
		if(doctor != null){
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", doctor);
			request.setAttribute("docName", doctor.getFullName());
			System.out.println("doctor is:"+ doctor); 
			dispatcher=request.getRequestDispatcher("u.jsp");	
		}
		else{
			System.out.println("invalid");
			dispatcher=request.getRequestDispatcher("docLogin.jsp");
		}
		return dispatcher;
		
	}
	
	

	public RequestDispatcher registerPatient(HttpServletRequest request) {
		String fullName=request.getParameter("fullName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String db = request.getParameter("dob");
		Date dob = DBConnection.date(db);
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String hNo = request.getParameter("hNo");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String contact = request.getParameter("contact");
		
		Patient patient =new Patient();
		PatientDAO patientDAO = new PatientDAO();
		patient.setFullName(fullName);
		patient.setDob(dob);
		patient.setUserName(userName);
		patient.setPassword(password);
		patient.setGender(gender);
		patient.setEmail(email);
		patient.setHouseNumber(hNo);
		patient.setStreet(street);
		patient.setCity(city);
		patient.setState(state);
		patient.setCountry(country);
		patient.setContact(contact);
		
		System.out.println("console print:"+patient);
		RequestDispatcher dispatcher=null;
		if(patientDAO.add(patient)!=0){
			request.setAttribute("regStatus", "Registration Success.!");
			dispatcher = request.getRequestDispatcher("patient_profile.jsp");
		}
		return dispatcher;
	}
	
	
	public RequestDispatcher registerDoctor(HttpServletRequest request) {
		String fullName=request.getParameter("fullName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String db = request.getParameter("dob");
		Date dob = DBConnection.date(db);
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String practisingFrom = request.getParameter("practiseYear");
		Date practiseYear = DBConnection.date(practisingFrom);
		String speciality = request.getParameter("speciality");
		String desc = request.getParameter("desc");
		String hNo = request.getParameter("hNo");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String contact = request.getParameter("contact");
		
		Doctor doctor =new Doctor();
		doctor.setFullName(fullName);
		doctor.setDob(dob);
		doctor.setUserName(userName);
		doctor.setPassword(password);
		doctor.setGender(gender);
		doctor.setEmail(email);
		doctor.setPractisingFrom(practiseYear);
		doctor.setSpecialisation(speciality);
		doctor.setDescription(desc);
		doctor.setHouseNumber(hNo);
		doctor.setStreet(street);
		doctor.setCity(city);
		doctor.setState(state);
		doctor.setCountry(country);
		doctor.setContact(contact);
		
		System.out.println("console print:"+doctor);
		DoctorDAO doctorDAO = new DoctorDAO();
		RequestDispatcher dispatcher=null;
		if(doctorDAO.add(doctor)!=0){
			request.setAttribute("regStatus", "Registration Success.!");
			dispatcher = request.getRequestDispatcher("doctorProfile.jsp");
		}
		return dispatcher;
	}
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
