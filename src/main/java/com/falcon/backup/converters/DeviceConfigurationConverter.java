package com.falcon.backup.converters;

public class DeviceConfigurationConverter {

	public com.falcon.backup.model.DeviceConfiguration convertEntityToModel(
			com.falcon.backup.entities.DeviceConfiguration entity) {
		com.falcon.backup.model.DeviceConfiguration model = new com.falcon.backup.model.DeviceConfiguration();
		model.setActionPollFrequency(entity.getActionPollFrequency());
		model.setConfigPollFrequency(entity.getConfigPollFrequency());
		model.setDeviceConfigurationId(entity.getDeviceConfigurationId());
		model.setEdgeTimeZone(entity.getEdgeTimeZone());
		model.setHeartbitSendFrenquency(entity.getHeartbitSendFrenquency());
		model.setCreationDate(entity.getCreationDate());
		model.setLastModifiedDate(entity.getLastModifiedDate());
		return model;
	}

	public com.falcon.backup.entities.DeviceConfiguration convertModelToEntity(
			com.falcon.backup.model.DeviceConfiguration model) {
		com.falcon.backup.entities.DeviceConfiguration entity = new com.falcon.backup.entities.DeviceConfiguration();
		entity.setActionPollFrequency(model.getActionPollFrequency());
		entity.setConfigPollFrequency(model.getConfigPollFrequency());
		entity.setDeviceConfigurationId(model.getDeviceConfigurationId());
		entity.setEdgeTimeZone(model.getEdgeTimeZone());
		entity.setHeartbitSendFrenquency(model.getHeartbitSendFrenquency());
		entity.setCreationDate(model.getCreationDate());
		entity.setLastModifiedDate(model.getLastModifiedDate());
		return entity;
	}
}
