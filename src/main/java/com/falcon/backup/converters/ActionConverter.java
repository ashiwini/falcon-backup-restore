package com.falcon.backup.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActionConverter {

	public com.falcon.backup.model.Action convertEntityToModel(com.falcon.backup.entities.Action entity) {
		com.falcon.backup.model.Action model = new com.falcon.backup.model.Action();
		model.setActionId(entity.getActionId());
		model.setActionType(com.falcon.backup.model.Action.ActionTypeEnum.valueOf(entity.getActionType()));
		model.setDeviceId(entity.getDeviceId());
		model.setExecutionStatus(
				com.falcon.backup.model.Action.ExecutionStatusEnum.valueOf(entity.getExecutionStatus()));
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

	public com.falcon.backup.entities.Action convertModelToEntity(com.falcon.backup.model.Action model) {
		com.falcon.backup.entities.Action entity = new com.falcon.backup.entities.Action();
		entity.setActionId(model.getActionId());
		entity.setActionType(model.getActionType().toString());
		entity.setDeviceId(model.getDeviceId());
		entity.setExecutionStatus(model.getExecutionStatus().toString());
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
	
	public List<com.falcon.backup.entities.Action> convertListModelToEntity(
			List<com.falcon.backup.model.Action> models) {
		List<com.falcon.backup.entities.Action> entities = new ArrayList<>();
		models.forEach((model) -> {
			entities.add(convertModelToEntity(model));
		});
		return entities;
	}

	public List<com.falcon.backup.model.Action> convertListEntityToModel(
			List<com.falcon.backup.entities.Action> entities) {
		List<com.falcon.backup.model.Action> models = new ArrayList<>();
		entities.forEach((model) -> {
			models.add(convertEntityToModel(model));
		});
		return models;
	}
}
