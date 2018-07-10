package com.falcon.backup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.falcon.backup.handler.ApplicationApi;
import com.falcon.backup.model.Application;
import com.falcon.backup.service.ApplicationService;

public class ApplicationController implements ApplicationApi {
	@Autowired
	ApplicationService service;

	@Override
	public ResponseEntity<Application> applicationApplicationIdGet(
			@PathVariable("application_id") Integer applicationId) {
		Application application = service.findById(applicationId);
		HttpStatus status = HttpStatus.OK;
		if (application == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(application, status);
	}

	@Override
	public ResponseEntity<List<Application>> applicationDeviceDeviceIdGet(@PathVariable("device_id") Integer deviceId) {
		List<Application> application = service.findByDeviceId(deviceId);
		HttpStatus status = HttpStatus.OK;
		if (application == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(application, status);
	}

	@Override
	public ResponseEntity<Application> applicationPost(@RequestBody Application body) {
		Application application = service.save(body);
		return new ResponseEntity<>(application, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Application>> applicationUserUserIdGet(Integer userId) {
		List<Application> application = service.findByUserId(userId);
		HttpStatus status = HttpStatus.OK;
		if (application == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(application, status);
	}

}
