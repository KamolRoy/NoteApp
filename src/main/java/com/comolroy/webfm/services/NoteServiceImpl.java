package com.comolroy.webfm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comolroy.webfm.entities.Note;
import com.comolroy.webfm.entities.User;
import com.comolroy.webfm.repositories.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService{
	
	private NoteRepository noteRepository;

	@Autowired
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@Override
	public List<Note> findByUser(User user) {
		// TODO Auto-generated method stub
		return (List<Note>)noteRepository.findByUser(user);
	}

	@Override
	public Note getNoteById(Long id) {
		// TODO Auto-generated method stub
		return noteRepository.findOne(id);
	}

	@Override
	public Note saveOrUpdate(Note note) {
		// TODO Auto-generated method stub
		return noteRepository.save(note);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		noteRepository.delete(id);
		
	}
	
	
	
}
