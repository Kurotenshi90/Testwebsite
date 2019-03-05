package com.crm.Controller.dto;

public class InformationDTO {
	private String firstname;
	private String  middlename;
	private String  lastname;
	private String  age;
	private String  gender;
	private String  study;
	private boolean  courseenglishdone ;
	private String  hoursenglish;
	private boolean  vacationenglish;
	private boolean  englishparents;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	public boolean getCourseenglishdone() {
		return courseenglishdone;
	}
	public void setCourseenglishdone(boolean courseenglishdone) {
		this.courseenglishdone = courseenglishdone;
	}
	public String getHoursenglish() {
		return hoursenglish;
	}
	public void setHoursenglish(String hoursenglish) {
		this.hoursenglish = hoursenglish;
	}
	public boolean getVacationenglish() {
		return vacationenglish;
	}
	public void setVacationenglish(boolean vacationenglish) {
		this.vacationenglish = vacationenglish;
	}
	public boolean getEnglishparents() {
		return englishparents;
	}
	public void setEnglishparents(boolean englishparents) {
		this.englishparents = englishparents;
	}	
}
