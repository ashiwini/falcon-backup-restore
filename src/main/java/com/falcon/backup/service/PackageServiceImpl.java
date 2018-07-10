package com.falcon.backup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.falcon.backup.converters.PackageConverter;
import com.falcon.backup.model.ModelPackage;
import com.falcon.backup.repositories.PackageRepository;

public class PackageServiceImpl implements PackageService {
	@Autowired
	private PackageRepository packageRepository;

	@Autowired
	private PackageConverter converter;
	
	@Override
	public ModelPackage save(ModelPackage model) {
		return converter.convertEntityToModel(packageRepository.save(converter.convertModelToEntity(model)));
	}

	@Override
	public ModelPackage findById(Integer packageId) {
		return converter.convertEntityToModel(packageRepository.findById(packageId).get());
	}

	@Override
	public List<ModelPackage> findByApplicationId(Integer applicationId) {
		return converter.convertListEntityToModel(packageRepository.findByApplications(applicationId));
	}


}
