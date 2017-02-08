package com.comolroy.webfm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comolroy.webfm.entities.User;
import com.comolroy.webfm.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserService userService;
	
	
	

	
	
	@Before
	public void init(){
		userService.deleteAllUser();
	}
	



	@Test
	public void createUser() {
		User user= new User();
		user.setEmail("sample@gmail.com");
		user.setName("sample");
		user.setPassword("1234");
		
		
		userService.updateOrSave(user);
		
		List<User> users= userService.getAllUser();
		
		assertEquals("One user should have been created and retrieved", 1, users.size());
	}

}
