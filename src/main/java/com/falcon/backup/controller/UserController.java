package com.falcon.backup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.falcon.backup.converters.UserConverter;
import com.falcon.backup.handler.UserApi;
import com.falcon.backup.model.User;
import com.falcon.backup.service.UserService;

@Controller
public class UserController implements UserApi {
	@Autowired
	private UserService service;

	UserConverter converter = new UserConverter();

	@Override
	public ResponseEntity<User> userPost(@RequestBody User body) {
		User newUser = service.save(body);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<User> userUserIdGet(@PathVariable("user_id")Integer userId) {
		User user = service.findById(userId);
		HttpStatus status = HttpStatus.OK;
		if (user == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(user, status);
	}

}
