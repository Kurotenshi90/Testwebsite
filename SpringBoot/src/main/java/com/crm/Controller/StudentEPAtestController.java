package com.crm.Controller;

import com.crm.Controller.dto.AnswerEpaDTO;
import com.crm.Controller.dto.BooleanDTO;
import com.crm.Controller.dto.InformationDTO;
import com.crm.Service.EPAtestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("epatest")
public class StudentEPAtestController {
	
    @Autowired
    private EPAtestService ePAtestService;

    @RequestMapping(value = "/addingtest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BooleanDTO insertStudentTest(@RequestBody AnswerEpaDTO answerEpaDTO){
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    BooleanDTO booleanDTO = new BooleanDTO();
	    System.out.println("test");
		if(session.getAttribute("login") != null
	    		&& (boolean) session.getAttribute("login")) {
					if(session.getAttribute("info") != null) {
						ePAtestService.insertStudentEPATest((InformationDTO) session.getAttribute("info"), answerEpaDTO, "" + ((new Date().getTime() - (long) session.getAttribute("startDate"))/1000));
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


