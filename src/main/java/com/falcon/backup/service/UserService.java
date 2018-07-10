package com.falcon.backup.service;

import com.falcon.backup.model.User;

public interface UserService {
	User save(User user);
	
	User findById(Integer userId);
}
