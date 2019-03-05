package com.crm.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.Controller.dto.AnswerDTO;
import com.crm.Controller.dto.AnswerEpaDTO;
import com.crm.Controller.dto.InformationDTO;
import com.crm.Dao.IStudentCTest;
import com.crm.Dao.IStudentEPATest;
import com.crm.Entity.StudentCTest;
import com.crm.Entity.StudentEPATest;

@Service
public class EPAtestService {
	@Autowired
	private IStudentEPATest iStudentEPATest;

	private String[][] anwersA = new String[][] { { "c" }, { "c" }, { "b" }, { "d" }, { "b" }, { "a" }, { "b" }, { "b" },{ "a" }, { "d" }, { "a" }, { "c" }, { "d" }, { "c" }, { "a" }, { "b" }, { "d" }, { "c" },{ "b" }, { "b" } };
    private String[][] anwersB = new String[][] {{ "b" }, { "b" }, { "d" }, { "c" }, { "c" }, { "d" }, { "b" }, { "c" },{ "b" }, { "a" }, { "b" }, { "c" }, { "c" }, { "e" }, { "e" }, { "e" }, { "d" }, { "a" },{ "e" }, { "e" } };
    private String[][] anwersC = new String[][] {{ "d" }, { "d" }, { "b" }, { "d" }, { "e" }, { "c" }, { "b" }, { "a" },{ "d" }, { "d" }, { "d" }, { "a" }, { "a" }, { "c" }, { "d" }, { "a" }, { "a" }, { "d" },{ "e" }, { "d" } };
    private String[][] anwersD = new String[][] { { "d" }, { "d" }, { "b" }, { "b" }, { "b" }, { "c" }, { "a" }, { "b" },{ "b" }, { "a" }, { "c" }, { "b" }, { "c" }, { "a" }, { "a" }, { "d" }, { "d" }, { "a" },{ "e" }, { "e" } };   									
    private String[][] anwersE = new String[][] { { "f" }, { "e" }, { "c" }, { "e" }, { "e" }, { "h" }, { "d" }, { "f" },{ "d" }, { "g" }, { "i" }, { "f" }, { "h" }, { "e" }, { "i" }, { "a" }, { "c" }, { "g" },{ "f" }, { "j" } };
    private String[][] anwersF = new String[][] {{ " ae" }, { " ce" }, { " ce" }, { " ce" }, { " ad" }, { " ce" }, { " ce" }, { " cf" }, { " df" }, { " bf" }, { " af" }, { " bd" }, { " cd" }, { " ac" }, { " ad" }, { " be" }, { " ac" },{ " bd" }, { " af" }, { " be"} };
    private String[][] anwersG = new String[][] {{ "c" }, { "b" }, { "d" }, { "b" }, { "c" }, { "d" }, { "b" }, { "d" },{ "d" }, { "c" }, { "a" }, { "b" }, { "b" }, { "b" }, { "d" }, { "b" }, { "d" }, { "a" },{ "a" }, { "d" } };
    private String[][] anwersH = new String[][] { { "c" }, { "b" }, { "c" }, { "a" }, { "c" }, { "b" }, { "a" }, { "b" },{ "a" }, { "a" }, { "b" }, { "c" }, { "b" }, { "c" }, { "d" }, { "a" }, { "d" }, { "b" },{ "d" }, { "d" } };


	public void insertStudentEPATest(InformationDTO info, AnswerEpaDTO answerEpaDTO, String time) {
		StudentEPATest studentEPATest = new StudentEPATest();
		
		
		studentEPATest.setAnswersA(answerEpaDTO.getAnswersA());
		studentEPATest.setAnswersB(answerEpaDTO.getAnswersB());
		studentEPATest.setAnswersC(answerEpaDTO.getAnswersC());
		studentEPATest.setAnswersD(answerEpaDTO.getAnswersD());
		studentEPATest.setAnswersE(answerEpaDTO.getAnswersE());
		studentEPATest.setAnswersF(answerEpaDTO.getAnswersF());
		studentEPATest.setAnswersG(answerEpaDTO.getAnswersG());
		studentEPATest.setAnswersH(answerEpaDTO.getAnswersH());
		
		studentEPATest.setTimeToDoTest(time);
		studentEPATest.setAge(info.getAge());
		studentEPATest.setFirstName(info.getFirstname());
		studentEPATest.setMiddleName(info.getMiddlename());
		studentEPATest.setLastName(info.getLastname());
		studentEPATest.setGender(info.getGender());
		studentEPATest.setStudy(info.getStudy());
		studentEPATest.setHoursEnglish(info.getHoursenglish());
		studentEPATest.setEnglishCourse(info.getCourseenglishdone());
		studentEPATest.setEnglishVacation(info.getVacationenglish());
		studentEPATest.setEnglishParents(info.getEnglishparents());
		// calculation
		calscore(studentEPATest);
		iStudentEPATest.save(studentEPATest);
	}

	private void calscore(StudentEPATest s) {
		String[] anwersAGiven = s.getAnswersA().split(",");
		String[] anwersBGiven = s.getAnswersB().split(",");
		String[] anwersCGiven = s.getAnswersC().split(",");
		String[] anwersDGiven = s.getAnswersD().split(",");
		String[] anwersEGiven = s.getAnswersE().split(",");
		String[] anwersFGiven = s.getAnswersF().split(",");
		String[] anwersGGiven = s.getAnswersG().split(",");
		String[] anwersHGiven = s.getAnswersH().split(",");
		
		s.setScoreA(compare(anwersA, anwersAGiven) * 5 + "%");
		s.setScoreB(compare(anwersB, anwersBGiven) * 5 + "%");
		s.setScoreC(compare(anwersC, anwersCGiven) * 5 + "%");
		s.setScoreD(compare(anwersD, anwersDGiven) * 5 + "%");
		s.setScoreE(compare(anwersE, anwersEGiven) * 5 + "%");
		s.setScoreF(compare(anwersF, anwersFGiven) * 5 + "%");
		s.setScoreG(compare(anwersG, anwersGGiven) * 5 + "%");
		s.setScoreH(compare(anwersH, anwersHGiven) * 5 + "%");

	}

	private int compare(String[][] a, String[] b) {
		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j].equals(b[i])) {
					counter++;
					break;
				}
			}
		}
		return counter;
	}
}
