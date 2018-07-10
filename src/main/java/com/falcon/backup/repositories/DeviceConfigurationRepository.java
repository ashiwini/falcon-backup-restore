package com.falcon.backup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.backup.entities.Device;
import com.falcon.backup.entities.DeviceConfiguration;

public interface DeviceConfigurationRepository extends CrudRepository<DeviceConfiguration, Integer> {
	List<Device> findByDeviceConfigurationId(Integer deviceConfigId);
}
