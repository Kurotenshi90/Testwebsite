package com.crm.Controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.crm.Controller.dto.BooleanDTO;
import com.crm.Controller.dto.InformationDTO;
import com.crm.Controller.dto.UserDTO;
import com.crm.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BooleanDTO getToken(@RequestBody UserDTO userDTO) {
		BooleanDTO booleanDTO = new BooleanDTO();
		if (userService.getUsers(userDTO)) {
			session();
			booleanDTO.setBool(true);
		} else {
			booleanDTO.setBool(false);
		}
		return booleanDTO;
	}

	@RequestMapping(path = "/logintrue", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BooleanDTO getLoginToken() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		BooleanDTO booleanDTO = new BooleanDTO();

		if (session.getAttribute("login") != null && (boolean) session.getAttribute("login")) {
			booleanDTO.setBool(true);
		} else {
			booleanDTO.setBool(false);
		}
		return booleanDTO;
	}

	@RequestMapping(path = "/formtrue", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BooleanDTO getFormToken() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		BooleanDTO booleanDTO = new BooleanDTO();

		if (session.getAttribute("login") != null && (boolean) session.getAttribute("login")) {
			if (session.getAttribute("info") != null) {
				booleanDTO.setBool(true);				
		    	session.setAttribute("startDate", new Date().getTime());
			} else {
				booleanDTO.setBool(false);
			}
		} else {
			booleanDTO.setBool(false);
		}
		return booleanDTO;
	}

	@RequestMapping(path = "/addinginfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BooleanDTO setinformation(@RequestBody InformationDTO informationDTO) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		BooleanDTO booleanDTO = new BooleanDTO();

		if (session.getAttribute("login") != null && (boolean) session.getAttribute("login")) {
			session.setAttribute("info", informationDTO);
			booleanDTO.setBool(true);
		} else {
			booleanDTO.setBool(false);
		}
		return booleanDTO;
	}

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		session.setAttribute("login", true);
		session.setMaxInactiveInterval(86400);
//	    if(session.getAttribute("initialized") != null
//	    		&& (boolean) session.getAttribute("initialized")) {
//	    	System.out.println("" + (new Date().getTime() - (long) session.getAttribute("startDate")));
//	    }else {
//	    	session.setAttribute("initialized", true);
//	    	session.setAttribute("startDate", new Date().getTime());
//	    }

		System.out.println(session.getId());
		return session; // true == allow create

	}
}
