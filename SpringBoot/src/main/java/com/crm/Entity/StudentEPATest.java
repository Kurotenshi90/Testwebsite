package com.crm.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class StudentEPATest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentIdCtest;

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	private String middleName;
	@NotNull
	private String age;
	@NotNull
	private String gender;
	
	@NotNull
	private String study;
	@NotNull
	private boolean englishCourse;
	@NotNull
	private String hoursEnglish;
	@NotNull
	private boolean englishVacation;
	@NotNull
	private boolean englishParents;
	@NotNull
	private String timeToDoTest;

	@NotNull
	private String scoreA;
	@NotNull
	private String scoreB;
	@NotNull
	private String scoreC;
	@NotNull
	private String scoreD;	
	@NotNull
	private String scoreE;
	@NotNull
	private String scoreF;
	@NotNull
	private String scoreG;
	@NotNull
	private String scoreH;

	@NotNull
	private String answersA;
	@NotNull
	private String answersB;
	@NotNull
	private String answersC;
	@NotNull
	private String answersD;
	@NotNull
	private String answersE;
	@NotNull
	private String answersF;
	@NotNull
	private String answersG;
	@NotNull
	private String answersH;

	public StudentEPATest(long studentIdCtest, @NotNull String firstName, @NotNull String lastName, String middleName,
			@NotNull String age, @NotNull String gender, @NotNull String study, @NotNull boolean englishCourse,
			@NotNull String hoursEnglish, @NotNull boolean englishVacation, @NotNull boolean englishParents,
			@NotNull String timeToDoTest, @NotNull String scoreA, @NotNull String scoreB, @NotNull String scoreC,
			@NotNull String scoreD, @NotNull String scoreE, @NotNull String scoreF, @NotNull String scoreG,
			@NotNull String scoreH, @NotNull String answersA, @NotNull String answersB, @NotNull String answersC,
			@NotNull String answersD, @NotNull String answersE, @NotNull String answersF, @NotNull String answersG,
			@NotNull String answersH) {
		super();
		this.studentIdCtest = studentIdCtest;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.age = age;
		this.gender = gender;
		this.study = study;
		this.englishCourse = englishCourse;
		this.hoursEnglish = hoursEnglish;
		this.englishVacation = englishVacation;
		this.englishParents = englishParents;
		this.timeToDoTest = timeToDoTest;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
		this.scoreC = scoreC;
		this.scoreD = scoreD;
		this.scoreE = scoreE;
		this.scoreF = scoreF;
		this.scoreG = scoreG;
		this.scoreH = scoreH;
		this.answersA = answersA;
		this.answersB = answersB;
		this.answersC = answersC;
		this.answersD = answersD;
		this.answersE = answersE;
		this.answersF = answersF;
		this.answersG = answersG;
		this.answersH = answersH;
	}

	public StudentEPATest() {
	}

	public long getStudentIdCtest() {
		return studentIdCtest;
	}

	public void setStudentIdCtest(long studentIdCtest) {
		this.studentIdCtest = studentIdCtest;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public boolean isEnglishCourse() {
		return englishCourse;
	}

	public void setEnglishCourse(boolean englishCourse) {
		this.englishCourse = englishCourse;
	}

	public String getHoursEnglish() {
		return hoursEnglish;
	}

	public void setHoursEnglish(String hoursEnglish) {
		this.hoursEnglish = hoursEnglish;
	}

	public boolean isEnglishVacation() {
		return englishVacation;
	}

	public void setEnglishVacation(boolean englishVacation) {
		this.englishVacation = englishVacation;
	}

	public boolean isEnglishParents() {
		return englishParents;
	}

	public void setEnglishParents(boolean englishParents) {
		this.englishParents = englishParents;
	}

	public String getTimeToDoTest() {
		return timeToDoTest;
	}

	public void setTimeToDoTest(String timeToDoTest) {
		this.timeToDoTest = timeToDoTest;
	}

	public String getScoreA() {
		return scoreA;
	}

	public void setScoreA(String scoreA) {
		this.scoreA = scoreA;
	}

	public String getScoreB() {
		return scoreB;
	}

	public void setScoreB(String scoreB) {
		this.scoreB = scoreB;
	}

	public String getScoreC() {
		return scoreC;
	}

	public void setScoreC(String scoreC) {
		this.scoreC = scoreC;
	}

	public String getScoreD() {
		return scoreD;
	}

	public void setScoreD(String scoreD) {
		this.scoreD = scoreD;
	}

	public String getScoreE() {
		return scoreE;
	}

	public void setScoreE(String scoreE) {
		this.scoreE = scoreE;
	}

	public String getScoreF() {
		return scoreF;
	}

	public void setScoreF(String scoreF) {
		this.scoreF = scoreF;
	}

	public String getScoreG() {
		return scoreG;
	}

	public void setScoreG(String scoreG) {
		this.scoreG = scoreG;
	}

	public String getScoreH() {
		return scoreH;
	}

	public void setScoreH(String scoreH) {
		this.scoreH = scoreH;
	}

	public String getAnswersA() {
		return answersA;
	}

	public void setAnswersA(String answersA) {
		this.answersA = answersA;
	}

	public String getAnswersB() {
		return answersB;
	}

	public void setAnswersB(String answersB) {
		this.answersB = answersB;
	}

	public String getAnswersC() {
		return answersC;
	}

	public void setAnswersC(String answersC) {
		this.answersC = answersC;
	}

	public String getAnswersD() {
		return answersD;
	}

	public void setAnswersD(String answersD) {
		this.answersD = answersD;
	}

	public String getAnswersE() {
		return answersE;
	}

	public void setAnswersE(String answersE) {
		this.answersE = answersE;
	}

	public String getAnswersF() {
		return answersF;
	}

	public void setAnswersF(String answersF) {
		this.answersF = answersF;
	}

	public String getAnswersG() {
		return answersG;
	}

	public void setAnswersG(String answersG) {
		this.answersG = answersG;
	}

	public String getAnswersH() {
		return answersH;
	}

	public void setAnswersH(String answersH) {
		this.answersH = answersH;
	}	
}
