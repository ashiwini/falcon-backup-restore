package com.falcon.backup.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PackageConverter {

	public com.falcon.backup.model.ModelPackage convertEntityToModel(com.falcon.backup.entities.Package entity) {
		com.falcon.backup.model.ModelPackage model = new com.falcon.backup.model.ModelPackage();
		model.setName(entity.getName());
		model.setPackageId(entity.getPackageId());
		model.setVersion(entity.getVersion());
		List<com.falcon.backup.model.Application> appModels = entity.getApplications().stream().map(app -> {
			com.falcon.backup.model.Application appModel = new com.falcon.backup.model.Application();
			appModel.setApplicationId(app.getApplicationId());
			appModel.setName(app.getName());
			appModel.setNamespace(app.getNamespace());
			appModel.setOwner(app.getOwner());
			appModel.setRepoName(app.getRepoName());
			appModel.setRepoUrl(app.getRepoUrl());
			appModel.setRunCommand(app.getRunCommand());
			appModel.setStarCount(app.getStarCount());
			appModel.setDistributionType(
					com.falcon.backup.model.Application.DistributionTypeEnum.valueOf(app.getDistributionType()));
			return appModel;
		}).collect(Collectors.toList());
		model.setApplications(appModels);
		return model;
	}

	public com.falcon.backup.entities.Package convertModelToEntity(com.falcon.backup.model.ModelPackage model) {
		com.falcon.backup.entities.Package entity = new com.falcon.backup.entities.Package();
		entity.setName(model.getName());
		entity.setPackageId(model.getPackageId());
		entity.setVersion(model.getVersion());

		List<com.falcon.backup.entities.Application> appEntities = model.getApplications().stream().map(app -> {
			com.falcon.backup.entities.Application appEntity = new com.falcon.backup.entities.Application();
			appEntity.setApplicationId(app.getApplicationId());
			appEntity.setName(app.getName());
			appEntity.setNamespace(app.getNamespace());
			appEntity.setOwner(app.getOwner());
			appEntity.setRepoName(app.getRepoName());
			appEntity.setRepoUrl(app.getRepoUrl());
			appEntity.setRunCommand(app.getRunCommand());
			appEntity.setStarCount(app.getStarCount());
			appEntity.setDistributionType(app.getDistributionType().toString());
			return appEntity;
		}).collect(Collectors.toList());
		entity.setApplications(appEntities);
		return entity;
	}
	
	public List<com.falcon.backup.entities.Package> convertListModelToEntity(
			List<com.falcon.backup.model.ModelPackage> models) {
		List<com.falcon.backup.entities.Package> entities = new ArrayList<>();
		models.forEach((model) -> {
			entities.add(convertModelToEntity(model));
		});
		return entities;
	}

	public List<com.falcon.backup.model.ModelPackage> convertListEntityToModel(
			List<com.falcon.backup.entities.Package> entities) {
		List<com.falcon.backup.model.ModelPackage> models = new ArrayList<>();
		entities.forEach((model) -> {
			models.add(convertEntityToModel(model));
		});
		return models;
	}
}
