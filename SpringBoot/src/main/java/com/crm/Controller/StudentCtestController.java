package com.crm.Controller;
import com.crm.Controller.dto.AnswerDTO;
import com.crm.Controller.dto.BooleanDTO;
import com.crm.Controller.dto.InformationDTO;
import com.crm.Entity.StudentCTest;
import com.crm.Service.CTtestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("ctest")
public class StudentCtestController {

    @Autowired
    private CTtestService cTtestService;

    @RequestMapping(method = RequestMethod.GET)
    public List<StudentCTest> getStudentCTestId(){
        return  cTtestService.getAllStudentCTest();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentCTest getStudentCTestId(@PathVariable("id") long id){
        return cTtestService.getStudentCTestId(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeStudentCTest(@RequestBody StudentCTest e){
        cTtestService.removeStudentCTest(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudentCTest(@RequestBody StudentCTest e){
        cTtestService.updateStudentCTest(e);
    }

    @RequestMapping(value = "/addingtest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BooleanDTO insertStudentCTest(@RequestBody AnswerDTO answerDTO){
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    BooleanDTO booleanDTO = new BooleanDTO();
	    
		if(session.getAttribute("login") != null
	    		&& (boolean) session.getAttribute("login")) {
					if(session.getAttribute("info") != null) {
						cTtestService.insertStudentCTest((InformationDTO) session.getAttribute("info"), answerDTO, "" + ((new Date().getTime() - (long) session.getAttribute("startDate"))/1000));
						booleanDTO.setBool(true);
					}
					else {
						booleanDTO.setBool(false);
					}			
		}		
		else {
			booleanDTO.setBool(false);
		}
		return booleanDTO;
        
    }
}
