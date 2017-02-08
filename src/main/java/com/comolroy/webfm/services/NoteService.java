package com.comolroy.webfm.services;

import java.util.List;

import com.comolroy.webfm.entities.Note;
import com.comolroy.webfm.entities.User;

public interface NoteService {
	
	public abstract List<Note> findByUser(User user);
	public abstract Note getNoteById(Long id);
	public abstract Note saveOrUpdate(Note note);
	public abstract void delete(Long id);

	
}
