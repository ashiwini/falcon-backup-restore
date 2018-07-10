package com.falcon.backup.service;

import java.util.List;

import com.falcon.backup.model.Device;

public interface DeviceService {
	Device save(Device device);

	Device findById(Integer deviceId);

	List<Device> findByUserId(Integer userId);

	List<Device> findByApplicationId(Integer applicationId);

	List<Device> findByDeviceConfigId(Integer deviceConfigId);

}
