package com.comolroy.webfm.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comolroy.webfm.dto.SignupForm;
import com.comolroy.webfm.entities.Note;
import com.comolroy.webfm.entities.User;
import com.comolroy.webfm.repositories.NoteRepository;
import com.comolroy.webfm.services.NoteService;
import com.comolroy.webfm.services.UserService;
import com.comolroy.webfm.util.ProjectUtil;
import com.comolroy.webfm.validators.SignupFormValidator;

@Controller
public class MasterController {
	
	private static final Log log = LogFactory.getLog(MasterController.class);
	
	private UserService userService;
	private NoteService noteService;
	private SignupFormValidator signupFormValidator;
	private NoteRepository noteRepository;
	
	
	
	@Autowired
	public MasterController(UserService userService, NoteService noteService, 
			SignupFormValidator signupFormValidator, NoteRepository noteRepository) {
		this.userService = userService;
		this.noteService = noteService;
		this.signupFormValidator = signupFormValidator;
		this.noteRepository = noteRepository;
	}
	
	/*
	 * The name "signupForm" need to be same with post method of signupWF
	 */
	@InitBinder("signupForm")
	protected void initSignupBinder(WebDataBinder binder){
		binder.setValidator(signupFormValidator);
	}

	@RequestMapping("/home")
	public String showHome(){
		return "home";
	}
	
	@RequestMapping("/userfirsthome")
	public Object forwardUserHome(){
		User user = ProjectUtil.getSessionUser();
		
		Note note = new Note();
		
		note.setTitle("Title1");
		note.setContent("Content1");
		note.setUser(user);
		
		noteService.saveOrUpdate(note);
		
		Note note2 = new Note();
		
		note2.setTitle("Title2");
		note2.setContent("Content2");
		note2.setUser(user);
		
		noteService.saveOrUpdate(note2);
		
		
		return "redirect:/userhome";
	}
	
	@RequestMapping("/userhome")
	public Object showUserHome(Model model){
		User user = ProjectUtil.getSessionUser();
		List<Note> notes = noteService.findByUser(user);
		model.addAttribute("notes", notes);
		return "userHome";
	}

	@RequestMapping("/allUser")
	@ResponseBody
	public String showAlllUser(){
		List<User> allUser=userService.getAllUser();
		
		for(Object user: allUser){
			log.info(user);
		}
		return "Done" + allUser.toString();
	}
	
	
	@RequestMapping("/note")
	@ResponseBody
	public Object showUserNote(){
		
		return noteRepository.findAll();
		
	}
	
	//Current User
	@RequestMapping(value="/currentUser")
	@ResponseBody
	public String showCurrentUser(){
		
		 return ProjectUtil.getSessionUser().toString();
	}
	

	/**
	 * 
	 * @param model 
	 * @return signupWF page for new account
	 */
	
	@RequestMapping(value= "/singupWF", method= RequestMethod.GET)
	public String signupWithWebFM(Model model){
		model.addAttribute("signupForm",new SignupForm());
		return "signupWF";
	}
	
	/**
	 * 
	 * @param signupForm
	 * @param result contain the validation error
	 * @return to home page if account creation successful. Otherwise return the same page with error information  
	 * Save new account information.
	 */
	@RequestMapping(value= "/singupWF", method= RequestMethod.POST)
	public String signupWithWebFM(@ModelAttribute("signupForm") @Valid SignupForm signupForm,
			BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return "signupWF";
		}
		
		userService.signup(signupForm);
		log.info(signupForm);
		
/*		ProjectUtil.flash(redirectAttributes, "success", "Hello! " + signupForm.getName().toString() +" signup is successful");
*/		ProjectUtil.flash(redirectAttributes, "success", "signupSuccess");

		return "redirect:/";
	}
	
	
	
	
	@RequestMapping(value="/userData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<String, Object> jsonData(){
		
		List<User> allUser=userService.getAllUser();
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("Type", "User");
		data.put("User", allUser);
		
		return data;
	}
	
}
