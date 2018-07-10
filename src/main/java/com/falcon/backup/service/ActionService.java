package com.falcon.backup.service;

import java.util.List;

import com.falcon.backup.model.Action;

public interface ActionService {
	Action save(Action action);

	Action findById(Integer actionId);
	
	List<Action> findByDeviceId(Integer deviceId);
}
