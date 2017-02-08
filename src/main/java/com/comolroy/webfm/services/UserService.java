package com.comolroy.webfm.services;

import java.util.List;

import com.comolroy.webfm.dto.SignupForm;
import com.comolroy.webfm.entities.User;

public interface UserService {
	
	public abstract void signup(SignupForm signup);
	
	public abstract List<User> getAllUser();
	
	public abstract User findOne(long userId);
	
	public abstract User updateOrSave(User user);
	
	public abstract void deleteAllUser();
	
}
