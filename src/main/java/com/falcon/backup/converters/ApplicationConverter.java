package com.falcon.backup.converters;

import java.util.ArrayList;
import java.util.List;

public class ApplicationConverter {

	public com.falcon.backup.model.Application convertEntityToModel(com.falcon.backup.entities.Application entity) {
		com.falcon.backup.model.Application appModel = new com.falcon.backup.model.Application();
		appModel.setApplicationId(entity.getApplicationId());
		appModel.setName(entity.getName());
		appModel.setNamespace(entity.getNamespace());
		appModel.setOwner(entity.getOwner());
		appModel.setRepoName(entity.getRepoName());
		appModel.setRepoUrl(entity.getRepoUrl());
		appModel.setRunCommand(entity.getRunCommand());
		appModel.setStarCount(entity.getStarCount());
		appModel.setDistributionType(
				com.falcon.backup.model.Application.DistributionTypeEnum.valueOf(entity.getDistributionType()));
		return appModel;
	}

	public com.falcon.backup.entities.Application convertModelToEntity(com.falcon.backup.model.Application model) {
		com.falcon.backup.entities.Application appEntity = new com.falcon.backup.entities.Application();
		appEntity.setApplicationId(model.getApplicationId());
		appEntity.setName(model.getName());
		appEntity.setNamespace(model.getNamespace());
		appEntity.setOwner(model.getOwner());
		appEntity.setRepoName(model.getRepoName());
		appEntity.setRepoUrl(model.getRepoUrl());
		appEntity.setRunCommand(model.getRunCommand());
		appEntity.setStarCount(model.getStarCount());
		appEntity.setDistributionType(model.getDistributionType().toString());
		return appEntity;
	}
	
	public List<com.falcon.backup.entities.Application> convertListModelToEntity(
			List<com.falcon.backup.model.Application> models) {
		List<com.falcon.backup.entities.Application> entities = new ArrayList<>();
		models.forEach((model) -> {
			entities.add(convertModelToEntity(model));
		});
		return entities;
	}

	public List<com.falcon.backup.model.Application> convertListEntityToModel(
			List<com.falcon.backup.entities.Application> entities) {
		List<com.falcon.backup.model.Application> models = new ArrayList<>();
		entities.forEach((model) -> {
			models.add(convertEntityToModel(model));
		});
		return models;
	}
}
