package com.falcon.backup.service;

import java.util.List;

import com.falcon.backup.model.Application;

public interface ApplicationService {
	Application save(Application application);

	Application findById(Integer applicationId);

	List<Application> findByUserId(Integer userId);
	
	List<Application> findByDeviceId(Integer deviceId);
}
