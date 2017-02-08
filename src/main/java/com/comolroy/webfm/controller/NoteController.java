package com.comolroy.webfm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comolroy.webfm.entities.Note;
import com.comolroy.webfm.entities.User;
import com.comolroy.webfm.services.NoteService;
import com.comolroy.webfm.util.ProjectUtil;

@Controller
public class NoteController {
	
	private NoteService noteService;
	
	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@RequestMapping(value="/updateNote", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> updateNote(@RequestBody Map<String, Object> data){
		
		Map<String, Object> rval = new HashMap<String, Object>();
		User user = ProjectUtil.getSessionUser();
		Note note = new Note();
		
		Long id = Long.parseLong((String) data.get("id"));
		
		Note note_old_value = noteService.getNoteById(id);
		
		note.setId(id);
		
		String fieldName = (String)data.get("thisField");
		
		if(fieldName.equals("title")){
			note.setTitle((String)data.get("thisText"));
			note.setContent(note_old_value.getContent());
		}else{
			note.setContent((String)data.get("thisText"));
			note.setTitle(note_old_value.getTitle());
		}
		
		note.setUser(user);
		try {
			noteService.saveOrUpdate(note);
			
			rval.put("success", true);
			rval.put("target", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rval.put("success", false);
			rval.put("target", id);
			return rval;
		}
		
		
		System.out.println(data);
		
		
		
		return rval;
	}
	

	@RequestMapping(value="/deleteNote", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> deleteNote(@RequestBody Map<String, Object> data){
		
		Map<String, Object> rval = new HashMap<String, Object>();
		Long id = Long.parseLong((String) data.get("id"));
		
		try {
			noteService.delete(id);
			rval.put("success", true);
			rval.put("target", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rval.put("success", false);
			rval.put("target", id);
			return rval;
		}
		
		return rval;
	}
	
	@RequestMapping(value="/saveNote", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> saveNote(@RequestBody Map<String, Object> data){
		
		Map<String, Object> rval = new HashMap<String, Object>();
		User user = ProjectUtil.getSessionUser();
		Note note = new Note();
		
		note.setTitle((String)data.get("title"));
		note.setContent((String)data.get("content"));
		note.setUser(user);
		
		 try {
			Note newNote=noteService.saveOrUpdate(note);
			rval.put("success", true);
			rval.put("target", newNote.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rval.put("success", false);
			rval.put("target", 0);
			return rval;
		}
		
		return rval;
	}
	
	@RequestMapping(value="/getNote", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object saveNote(){
		
		User user = ProjectUtil.getSessionUser();
		
		return noteService.findByUser(user);
	}
}
