package com.falcon.backup.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeviceConverter {

	public com.falcon.backup.model.Device convertEntityToModel(com.falcon.backup.entities.Device entity) {
		com.falcon.backup.model.Device deviceModel = new com.falcon.backup.model.Device();
		deviceModel.setCreatedBy(entity.getCreatedBy());
		deviceModel.setCreationDate(entity.getCreationDate());
		deviceModel.setDeviceId(entity.getDeviceId());
		deviceModel.setIsOnline(entity.getIsOnline());
		deviceModel.setLastModifiedBy(entity.getLastModifiedBy());
		deviceModel.setLastModifiedDate(entity.getLastModifiedDate());
		deviceModel.setName(entity.getName());
		deviceModel.setToken(entity.getToken());
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
		List<com.falcon.backup.model.Action> appActions = entity.getActions().stream().map(action -> {
			com.falcon.backup.model.Action actionModel = new com.falcon.backup.model.Action();
			actionModel.setActionId(action.getActionId());
			actionModel.setActionType(com.falcon.backup.model.Action.ActionTypeEnum.valueOf(action.getActionType()));
			actionModel.setDeviceId(action.getDeviceId());
			actionModel.setExecutionStatus(
					com.falcon.backup.model.Action.ExecutionStatusEnum.valueOf(action.getExecutionStatus()));
			List<com.falcon.backup.model.Application> appActionModels = action.getApplications().stream().map(app -> {
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
			actionModel.setApplications(appActionModels);
			return actionModel;
		}).collect(Collectors.toList());
		deviceModel.setApplications(appModels);
		deviceModel.setActions(appActions);
		return deviceModel;
	}

	public com.falcon.backup.entities.Device convertModelToEntity(com.falcon.backup.model.Device model) {
		com.falcon.backup.entities.Device deviceEntity = new com.falcon.backup.entities.Device();
		deviceEntity.setCreatedBy(model.getCreatedBy());
		deviceEntity.setCreationDate(model.getCreationDate());
		deviceEntity.setDeviceId(model.getDeviceId());
		deviceEntity.setIsOnline(model.getIsOnline());
		deviceEntity.setLastModifiedBy(model.getLastModifiedBy());
		deviceEntity.setLastModifiedDate(model.getLastModifiedDate());
		deviceEntity.setName(model.getName());
		deviceEntity.setToken(model.getToken());
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
			return appEntity;
		}).collect(Collectors.toList());

		List<com.falcon.backup.entities.Action> appActions = model.getActions().stream().map(action -> {
			com.falcon.backup.entities.Action actionEntity = new com.falcon.backup.entities.Action();
			actionEntity.setActionId(action.getActionId());
			actionEntity.setActionType(action.getActionType().toString());
			actionEntity.setDeviceId(action.getDeviceId());
			actionEntity.setExecutionStatus(action.getExecutionStatus().toString());
			List<com.falcon.backup.entities.Application> appActionEntities = action.getApplications().stream()
					.map(app -> {
						com.falcon.backup.entities.Application appEntity = new com.falcon.backup.entities.Application();
						appEntity.setApplicationId(app.getApplicationId());
						appEntity.setName(app.getName());
						appEntity.setNamespace(app.getNamespace());
						appEntity.setOwner(app.getOwner());
						appEntity.setRepoName(app.getRepoName());
						appEntity.setRepoUrl(app.getRepoUrl());
						appEntity.setRunCommand(app.getRunCommand());
						appEntity.setStarCount(app.getStarCount());
						return appEntity;
					}).collect(Collectors.toList());
			actionEntity.setApplications(appActionEntities);
			return actionEntity;
		}).collect(Collectors.toList());
		deviceEntity.setActions(appActions);
		deviceEntity.setApplications(appEntities);
		return deviceEntity;
	}

	public List<com.falcon.backup.entities.Device> convertListModelToEntity(
			List<com.falcon.backup.model.Device> models) {
		List<com.falcon.backup.entities.Device> entities = new ArrayList<>();
		models.forEach((model) -> {
			entities.add(convertModelToEntity(model));
		});
		return entities;
	}

	public List<com.falcon.backup.model.Device> convertListEntityToModel(
			List<com.falcon.backup.entities.Device> entities) {
		List<com.falcon.backup.model.Device> models = new ArrayList<>();
		entities.forEach((model) -> {
			models.add(convertEntityToModel(model));
		});
		return models;
	}
}
