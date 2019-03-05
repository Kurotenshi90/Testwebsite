package com.crm.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.Controller.dto.UserDTO;
import com.crm.Dao.IUser;
import com.crm.Entity.User;

@Service
public class UserService {
    @Autowired
    private IUser iUser;

    public boolean getUsers(UserDTO userDTO){
        List<User> user = new ArrayList<>();
        iUser.findAll().forEach(user::add);
               
        for(User u: user) {
        	if(u.getUsername().equals(userDTO.getUserName()) && u.getPassword().equals(userDTO.getPassWord())){
        		return true;
        	}
        }  
        return false;
    }
}
