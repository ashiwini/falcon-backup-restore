package com.falcon.backup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.backup.entities.Action;

public interface ActionRepository extends CrudRepository<Action, Integer> {
	List<Action> findByDeviceId(Integer deviceId);
}
