package com.falcon.backup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falcon.backup.converters.UserConverter;
import com.falcon.backup.model.User;
import com.falcon.backup.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter converter;

	@Override
	public User save(User user) {
		return converter.convertEntityToModel(userRepository.save(converter.convertModelToEntity(user)));
	}

	@Override
	public User findById(Integer userId) {
		return converter.convertEntityToModel(userRepository.findById(userId).get());
		
	}

}
