package com.falcon.backup.service;

import java.util.List;

import com.falcon.backup.model.ModelPackage;

public interface PackageService {
	ModelPackage save(ModelPackage device);

	ModelPackage findById(Integer deviceId);
	
	List<ModelPackage> findByApplicationId(Integer applicationId);
}
