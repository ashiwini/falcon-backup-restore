package com.falcon.backup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.falcon.backup.handler.DevicesApi;
import com.falcon.backup.model.Device;
import com.falcon.backup.service.DeviceService;

public class DeviceController implements DevicesApi {
	
	@Autowired
	DeviceService service;

	@Override
	public ResponseEntity<List<Device>> devicesApplicationApplicationIdGet(@PathVariable("application_id") Integer applicationId) {
		List<Device> device = service.findByApplicationId(applicationId);
		HttpStatus status = HttpStatus.OK;
		if (device == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(device, status);
	}

	@Override
	public ResponseEntity<Device> devicesDeviceIdGet(@PathVariable("device_id") Integer deviceId) {
		Device device = service.findById(deviceId);
		HttpStatus status = HttpStatus.OK;
		if (device == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(device, status);
	}

	@Override
	public ResponseEntity<List<Device>> devicesDeviceconfigDeviceconfigIdGet(@PathVariable("deviceconfig_id") Integer deviceconfigId) {
		List<Device> device = service.findByDeviceConfigId(deviceconfigId);
		HttpStatus status = HttpStatus.OK;
		if (device == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(device, status);
	
	}

	@Override
	public ResponseEntity<Device> devicesPost(@RequestBody Device body) {
		Device device = service.save(body);
		return new ResponseEntity<>(device, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Device>> devicesUserUserIdGet(@PathVariable("user_id") Integer userId) {
		List<Device> device = service.findByUserId(userId);
		HttpStatus status = HttpStatus.OK;
		if (device == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(device, status);
	}
	

}
