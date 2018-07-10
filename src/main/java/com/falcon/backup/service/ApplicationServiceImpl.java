package com.falcon.backup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.falcon.backup.converters.ApplicationConverter;
import com.falcon.backup.model.Application;
import com.falcon.backup.repositories.ApplicationRepository;
import com.falcon.backup.repositories.DeviceRepository;

public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;

	@Autowired
	private ApplicationConverter converter;
	
	@Override
	public Application save(Application application) {
		return converter.convertEntityToModel(applicationRepository.save(converter.convertModelToEntity(application)));
	}

	@Override
	public Application findById(Integer applicationId) {
		return converter.convertEntityToModel(applicationRepository.findById(applicationId).get());
	}

	@Override
	public List<Application> findByUserId(Integer userId) {
		return converter.convertListEntityToModel(applicationRepository.findByOwner(userId));
	}

	@Override
	public List<Application> findByDeviceId(Integer deviceId) {
		return converter.convertListEntityToModel(deviceRepository.findApplicationsByDeviceId(deviceId));
	}

}
