package com.crm.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.Controller.dto.AnswerDTO;
import com.crm.Controller.dto.InformationDTO;
import com.crm.Dao.IStudentCTest;
import com.crm.Entity.StudentCTest;

@Service
public class CTtestService {
	@Autowired
	private IStudentCTest iStudentCTest;

	private String[][] anwersA = new String[][] { { "ve" }, { "he" }, { "arm", "ert" }, { "as", "ad" }, { "en" },
			{ "ional", "ioning" }, { "ny" }, { "ne" }, { "uder" }, { "tted" }, { "rity" }, { "bing" }, { "he" },
			{ "ough" }, { "ken" }, { "dow" }, { "ut" }, { "te" }, { "he" }, { "re" }, { "o" }, { "rth" }, { "der" },
			{ "ros" }, { "erts" } };
	private String[][] anwersB = new String[][] { { "ntry" }, { "tains" }, { "ins" }, { "ches" }, { "efs" }, { "n" },
			{ "f" }, { "ciates" }, { "ural" }, { "nd" }, { "et" }, { "er" }, { "onal" }, { "nd" }, { "rves" },
			{ "tect" }, { "age" }, { "onment" }, { "as" }, { "he" }, { "rce" }, { "seas", "all" }, { "aris" },
			{ "nised", "nized" }, { "at" } };
	private String[][] anwersC = new String[][] { { "dates" }, { "ve" }, { "gate" }, { "cular" }, { "ing" }, { "bal" },
			{ "om" }, { "iner", "iners" }, { "y" }, { "ad" }, { "he" }, { "ys", "id" }, { "ew" }, { "ll" },
			{ "endent" }, { "nd" }, { "ation" }, { "ver" }, { "st" }, { "he" }, { "wn" }, { "ests" }, { "nge", "nges" },
			{ "use" }, { "ss" } };
	private String[][] anwersD = new String[][] { { "gan" }, { "el" }, { "ngly" }, { "he" }, { "re" }, { "eir" },
			{ "nd" }, { "rk" }, { "iding" }, { "r" }, { "n" }, { "ile" }, { "ut" }, { "o" }, { "ll" }, { "re" },
			{ "til" }, { "int" }, { "low" }, { "ions", "ion" }, { "les", "le" }, { "tish" }, { "n" }, { "eenth" },
			{ "icans", "ica" } };

	public List<StudentCTest> getAllStudentCTest() {
		List<StudentCTest> studentCTests = new ArrayList<>();
		iStudentCTest.findAll().forEach(studentCTests::add);
		return studentCTests;
	}

	public StudentCTest getStudentCTestId(long id) {
		return iStudentCTest.findById(id).get();
	}

	public void removeStudentCTest(StudentCTest s) {
		iStudentCTest.delete(s);
	}

	public void updateStudentCTest(StudentCTest s) {
		iStudentCTest.save(s);
	}

	public void insertStudentCTest(InformationDTO info, AnswerDTO answerDTO, String time) {
		StudentCTest studentCTest = new StudentCTest();
		
		
		studentCTest.setAnswersA(answerDTO.getAnswersA());
		studentCTest.setAnswersB(answerDTO.getAnswersB());
		studentCTest.setAnswersC(answerDTO.getAnswersC());
		studentCTest.setAnswersD(answerDTO.getAnswersD());
		studentCTest.setTimeToDoTest(time);
		studentCTest.setAge(info.getAge());
		studentCTest.setFirstName(info.getFirstname());
		studentCTest.setMiddleName(info.getMiddlename());
		studentCTest.setLastName(info.getLastname());
		studentCTest.setGender(info.getGender());
		studentCTest.setStudy(info.getStudy());
		studentCTest.setHoursEnglish(info.getHoursenglish());
		studentCTest.setEnglishCourse(info.getCourseenglishdone());
		studentCTest.setEnglishVacation(info.getVacationenglish());
		studentCTest.setEnglishParents(info.getEnglishparents());
		// calculation
		calscore(studentCTest);
		iStudentCTest.save(studentCTest);
	}

	private void calscore(StudentCTest s) {
		String[] anwersAGiven = s.getAnswersA().split(",");
		String[] anwersBGiven = s.getAnswersB().split(",");
		String[] anwersCGiven = s.getAnswersC().split(",");
		String[] anwersDGiven = s.getAnswersD().split(",");
		s.setScoreA(compare(anwersA, anwersAGiven) * 4 + "%");
		s.setScoreB(compare(anwersB, anwersBGiven) * 4 + "%");
		s.setScoreC(compare(anwersC, anwersCGiven) * 4 + "%");
		s.setScoreD(compare(anwersD, anwersDGiven) * 4 + "%");

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
