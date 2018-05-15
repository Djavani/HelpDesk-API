package com.drgomes.helpdesk.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.drgomes.helpdesk.api.entity.User;

public interface UserService {
		
	public User findByEmail(String email);
	
	public User createOrUpdate(User user);
	
	public Optional<User> findById(String id);
	
	public void delete(String id);
	
	public Page<User> findAll(int page, int count);

}
