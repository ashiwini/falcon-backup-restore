package com.falcon.backup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.falcon.backup.converters.ActionConverter;
import com.falcon.backup.model.Action;
import com.falcon.backup.repositories.ActionRepository;

public class ActionServiceImpl implements ActionService  {
	@Autowired
	private ActionRepository actionRepository;

	@Autowired
	private ActionConverter converter;
	
	@Override
	public Action save(Action action) {
		return converter.convertEntityToModel(actionRepository.save(converter.convertModelToEntity(action)));
	}

	@Override
	public Action findById(Integer actionId) {
		return converter.convertEntityToModel(actionRepository.findById(actionId).get());
	}

	@Override
	public List<Action> findByDeviceId(Integer deviceId) {
		return converter.convertListEntityToModel(actionRepository.findByDeviceId(deviceId));
	}

}
