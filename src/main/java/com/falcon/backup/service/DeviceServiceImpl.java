package com.falcon.backup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.falcon.backup.converters.DeviceConverter;
import com.falcon.backup.model.Device;
import com.falcon.backup.repositories.DeviceConfigurationRepository;
import com.falcon.backup.repositories.DeviceRepository;

public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private DeviceConfigurationRepository deviceConfigRepository;

	@Autowired
	private DeviceConverter converter;

	@Override
	public Device save(Device device) {
		return converter.convertEntityToModel(deviceRepository.save(converter.convertModelToEntity(device)));
	}

	@Override
	public Device findById(Integer deviceId) {
		return converter.convertEntityToModel(deviceRepository.findById(deviceId).get());
	}

	@Override
	public List<Device> findByUserId(Integer userId) {
		return converter.convertListEntityToModel(deviceRepository.findByCreatedBy(userId));
	}

	@Override
	public List<Device> findByApplicationId(Integer applicationId) {
		return converter.convertListEntityToModel(deviceRepository.findByApplications(applicationId));
	}

	@Override
	public List<Device> findByDeviceConfigId(Integer deviceConfigId) {
		return converter.convertListEntityToModel(deviceConfigRepository.findByDeviceConfigurationId(deviceConfigId));
	}

}
