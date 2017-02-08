package com.comolroy.webfm.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comolroy.webfm.dto.UserDetailsImpl;
import com.comolroy.webfm.entities.User;

@Component
public class ProjectUtil {
	
	private static MessageSource messageSource;
	
	@Autowired
	public ProjectUtil(MessageSource messageSource){
		ProjectUtil.messageSource = messageSource;
	}

	public static void flash(RedirectAttributes redirectAttributes, String kind, String messageKey) {
		// TODO Auto-generated method stub
		redirectAttributes.addFlashAttribute("flashKind", kind);
		redirectAttributes.addFlashAttribute("flashMessage", ProjectUtil.getMessage(messageKey));
	}

	/*
	 * Object... means zero or more argument.
	 */
	private static String getMessage(String messageKey, Object...args) {
		// TODO Auto-generated method stub
		return messageSource.getMessage(messageKey, args, Locale.getDefault()  );
	}
	
	public static User getSessionUser() {
		UserDetailsImpl auth = getAuth();
		return auth == null? null: auth.getUser();
	}

	public static UserDetailsImpl getAuth(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null){
			Object principal = auth.getPrincipal();
			
			
			if(principal instanceof UserDetailsImpl){
				return (UserDetailsImpl)principal;
			} 
		}
		return null;
	}
	
}
