package com.falcon.backup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.backup.entities.Application;
import com.falcon.backup.entities.Device;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
	
	List<Device> findByCreatedBy(Integer userId);
	
	List<Device> findByApplications(Integer applicationId);
	
	List<Application> findApplicationsByDeviceId(Integer deviceId);
}
