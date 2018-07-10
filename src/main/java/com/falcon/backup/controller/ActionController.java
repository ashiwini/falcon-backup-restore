package com.falcon.backup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.falcon.backup.handler.ActionApi;
import com.falcon.backup.model.Action;
import com.falcon.backup.service.ActionService;

public class ActionController implements ActionApi {
	@Autowired
	ActionService service;
	
	@Override
	public ResponseEntity<Action> actionActionIdGet(@PathVariable("action_id") Integer actionId) {
		Action action = service.findById(actionId);
		HttpStatus status = HttpStatus.OK;
		if (action == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(action, status);
	}

	@Override
	public ResponseEntity<List<Action>> actionDeviceDeviceIdGet(@PathVariable("device_id") Integer deviceId) {
		List<Action> action = service.findByDeviceId(deviceId);
		HttpStatus status = HttpStatus.OK;
		if (action == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(action, status);
	}

	@Override
	public ResponseEntity<Action> actionPost(@RequestBody Action body) {
		Action action = service.save(body);
		return new ResponseEntity<>(action, HttpStatus.CREATED);
	}

}
