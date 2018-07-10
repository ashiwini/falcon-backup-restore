package com.falcon.backup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.falcon.backup.handler.PackageApi;
import com.falcon.backup.model.ModelPackage;
import com.falcon.backup.service.PackageService;

public class PackageController implements PackageApi{

	@Autowired
	PackageService service;

	@Override
	public ResponseEntity<ModelPackage> packagePost(@RequestBody ModelPackage body) {
		ModelPackage pack = service.save(body);
		return new ResponseEntity<>(pack, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<ModelPackage>> packageApplicationApplicationIdGet(@PathVariable("application_id") Integer applicationId) {
		List<ModelPackage> pack = service.findByApplicationId(applicationId);
		HttpStatus status = HttpStatus.OK;
		if (pack == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(pack, status);
	}

	@Override
	public ResponseEntity<ModelPackage> packagePackageIdGet(Integer packageId) {
		ModelPackage pack = service.findById(packageId);
		HttpStatus status = HttpStatus.OK;
		if (pack == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(pack, status);
	}

}
