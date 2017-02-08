package com.comolroy.webfm.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comolroy.webfm.dto.SignupForm;
import com.comolroy.webfm.entities.User;
import com.comolroy.webfm.repositories.UserRepository;

@Component
@Primary
public class SignupFormValidator extends LocalValidatorFactoryBean{
	
	private UserRepository userRepository;
	
	@Autowired
	public SignupFormValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz){
		return clazz.isAssignableFrom(SignupForm.class);
	}

	@Override
	public void validate(Object target, Errors errors, Object... validationHints) {
		super.validate(target, errors, validationHints);
		
		if(!errors.hasErrors()){
			
			SignupForm signupForm=(SignupForm) target;
			User user = userRepository.findByEmail(signupForm.getEmail());
			
			if(user != null){
				errors.rejectValue("email", "emailNotUnique");
			}
			
			
		}
		
	}
	
	
	
	
	
}
