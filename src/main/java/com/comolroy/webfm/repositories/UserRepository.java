package com.comolroy.webfm.repositories;

import org.springframework.data.repository.CrudRepository;

import com.comolroy.webfm.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	User findById(long userId);
	

}
