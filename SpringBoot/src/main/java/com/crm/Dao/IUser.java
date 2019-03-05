package com.crm.Dao;

import com.crm.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<User, Long> {

}
