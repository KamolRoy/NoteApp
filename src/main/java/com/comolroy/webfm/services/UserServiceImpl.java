package com.comolroy.webfm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.comolroy.webfm.dto.SignupForm;
import com.comolroy.webfm.dto.UserDetailsImpl;
import com.comolroy.webfm.entities.User;
import com.comolroy.webfm.repositories.UserRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

	
	private UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>)userRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void signup(SignupForm signupForm) {
		// TODO Auto-generated method stub
		final User user = new User();
		user.setEmail(signupForm.getEmail());
		user.setName(signupForm.getName());
		user.setPassword(signupForm.getPassword());
		
		userRepository.save(user);
		
	}

	

	@Override
	public User updateOrSave(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	

	//Implement method for UserDetailsService
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(user);
	}
	
	
	/*
	 * Called form findOne method
	 */
	
	public User loadUserById(long userId) {
		return (User) userRepository.findById(userId);
	}

	
	@Override
	public User findOne(long userId) {
		User user = loadUserById(userId);
		
		return user;
	}

	@Override
	public void deleteAllUser() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}
	
	

}
