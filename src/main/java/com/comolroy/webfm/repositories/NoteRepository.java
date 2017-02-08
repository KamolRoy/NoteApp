package com.comolroy.webfm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.comolroy.webfm.entities.Note;
import com.comolroy.webfm.entities.User;

public interface NoteRepository  extends CrudRepository<Note, Long>{
	
	List<Note> findByUser(User user);

	
}
