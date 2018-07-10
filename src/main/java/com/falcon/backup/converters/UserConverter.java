package com.falcon.backup.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

	public com.falcon.backup.model.User convertEntityToModel(com.falcon.backup.entities.User entity) {

		com.falcon.backup.model.User model = new com.falcon.backup.model.User();
		model.setUserId(entity.getUserId());
		model.setUsername(entity.getUsername());
		model.setCreationDate(entity.getCreationDate());
		model.setLastModifiedDate(entity.getLastModifiedDate());
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

		List<com.falcon.backup.model.Device> deviceModels = entity.getDevices().stream().map(device -> {

			com.falcon.backup.model.Device deviceModel = new com.falcon.backup.model.Device();
			deviceModel.setCreatedBy(device.getCreatedBy());
			deviceModel.setCreationDate(device.getCreationDate());
			deviceModel.setDeviceId(device.getDeviceId());
			deviceModel.setIsOnline(device.getIsOnline());
			deviceModel.setLastModifiedBy(device.getLastModifiedBy());
			deviceModel.setLastModifiedDate(device.getLastModifiedDate());
			deviceModel.setName(device.getName());
			deviceModel.setToken(device.getToken());
			List<com.falcon.backup.model.Action> appActions = device.getActions().stream().map(action -> {
				com.falcon.backup.model.Action actionModel = new com.falcon.backup.model.Action();
				actionModel.setActionId(action.getActionId());
				actionModel
						.setActionType(com.falcon.backup.model.Action.ActionTypeEnum.valueOf(action.getActionType()));
				actionModel.setDeviceId(action.getDeviceId());
				actionModel.setExecutionStatus(
						com.falcon.backup.model.Action.ExecutionStatusEnum.valueOf(action.getExecutionStatus()));
				List<com.falcon.backup.model.Application> appActionModels = action.getApplications().stream()
						.map(app -> {
							com.falcon.backup.model.Application appModel = new com.falcon.backup.model.Application();
							appModel.setApplicationId(app.getApplicationId());
							appModel.setName(app.getName());
							appModel.setNamespace(app.getNamespace());
							appModel.setOwner(app.getOwner());
							appModel.setRepoName(app.getRepoName());
							appModel.setRepoUrl(app.getRepoUrl());
							appModel.setRunCommand(app.getRunCommand());
							appModel.setStarCount(app.getStarCount());
							appModel.setDistributionType(com.falcon.backup.model.Application.DistributionTypeEnum
									.valueOf(app.getDistributionType()));
							return appModel;
						}).collect(Collectors.toList());
				actionModel.setApplications(appActionModels);
				return actionModel;
			}).collect(Collectors.toList());
			deviceModel.setActions(appActions);
			return deviceModel;
		}).collect(Collectors.toList());

		model.setApplications(appModels);
		model.setDevices(deviceModels);
		return model;
	}

	public com.falcon.backup.entities.User convertModelToEntity(com.falcon.backup.model.User model) {

		com.falcon.backup.entities.User entity = new com.falcon.backup.entities.User();
		entity.setUserId(model.getUserId());
		entity.setUsername(model.getUsername());
		entity.setCreationDate(model.getCreationDate());
		entity.setLastModifiedDate(model.getLastModifiedDate());
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
		List<com.falcon.backup.entities.Device> deviceEntities = model.getDevices().stream().map(device -> {
			com.falcon.backup.entities.Device deviceEntity = new com.falcon.backup.entities.Device();
			deviceEntity.setCreatedBy(device.getCreatedBy());
			deviceEntity.setCreationDate(device.getCreationDate());
			deviceEntity.setDeviceId(device.getDeviceId());
			deviceEntity.setIsOnline(device.getIsOnline());
			deviceEntity.setLastModifiedBy(device.getLastModifiedBy());
			deviceEntity.setLastModifiedDate(device.getLastModifiedDate());
			deviceEntity.setName(device.getName());
			deviceEntity.setToken(device.getToken());

			List<com.falcon.backup.entities.Action> appActions = device.getActions().stream().map(action -> {
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
			return deviceEntity;
		}).collect(Collectors.toList());
		entity.setApplications(appEntities);
		entity.setDevices(deviceEntities);
		return entity;
	}

	public Iterable<com.falcon.backup.entities.User> convertListModelToEntity(
			Iterable<com.falcon.backup.model.User> models) {
		List<com.falcon.backup.entities.User> entities = new ArrayList<>();
		models.forEach((model) -> {
			entities.add(convertModelToEntity(model));
		});
		return entities;
	}

	public Iterable<com.falcon.backup.model.User> convertListEntityToModel(
			Iterable<com.falcon.backup.entities.User> entities) {
		List<com.falcon.backup.model.User> models = new ArrayList<>();
		entities.forEach((model) -> {
			models.add(convertEntityToModel(model));
		});
		return models;
	}
}
